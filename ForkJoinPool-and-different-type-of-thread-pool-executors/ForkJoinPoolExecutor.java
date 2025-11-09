import java.util.*;
import java.util.concurrent.*;

/*

Core structure
    Each worker thread owns a double‑ended deque (work‑stealing queue).
    External submissions go to a shared submission queue.
Task execution flow
    Non‑divisible task: when a worker takes it (from its deque or the submission queue), it runs compute() directly; no further splitting.
    Divisible task: the worker splits it into subtasks. It immediately continues with one subtask and pushes the remaining subtasks onto its own deque.

    Where workers get work (priority order)
    Own deque: pop from the top (LIFO). This favors locality and finishes most recently created subtasks first.
    Submission queue: if own deque is empty, poll the global submission queue.
    Other workers’ deques: if still empty, steal from the bottom (FIFO) of another worker’s deque.

Why this works well
    Owners use LIFO to keep hot data in cache.
    Thieves take the oldest tasks (bottom), spreading work while minimizing clashes with owners.
    Splitting then pushing “other” subtasks exposes parallelism; executing one subtask immediately avoids excessive queuing.

“Work‑stealing pool” is a scheduling strategy/architecture, not a JDK interface.

Java’s concrete implementation of that strategy is ForkJoinPool (a class). It implements ExecutorService, not a “WorkStealingPool” interface.
Executors.newWorkStealingPool(...) just returns a ForkJoinPool configured for that strategy.

*/

class ComputeSumTask extends RecursiveTask <Integer> {
    private int start;
    private int end;

    public ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer compute() {
        // smallest task which should be executed is when the subarray has 4 or fewer elements.
        // If not, divide the subarray into smaller parts until a small partition is achieved.

        if ((end-start) <= 4) {
            int totalSum = 0;
            for (int i=start;i<=end;i++) {
                totalSum+=i;
            }
            return totalSum;
        }
        else {
            // split the task
            int mid = start+ (end-start)/2;
            ComputeSumTask leftTask = new ComputeSumTask(start,mid);
            ComputeSumTask rightTask = new ComputeSumTask(mid+1,end);


            // create two different subtasks with fork() API
            leftTask.fork(); // the original thread that picked up the big task, will start operating on this
            rightTask.fork(); // this subtask will be pushed to the original thread's work stealing queue

            // combine the results of subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            return leftResult+rightResult;
        }
    }

};

public class ForkJoinPoolExecutor {
    public static void main(String [] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // example: submit a task to compute sum of elements from 0 to 100. This big task will be further divided into subtasks and the subtasks will be executed by different threads in fork join pool
        Future <Integer> obj = pool.submit(new ComputeSumTask(0,100));
        try {
            System.out.println("Result is: "+ obj.get());
        }
        catch (InterruptedException | ExecutionException ex) {
            System.out.println("Got exception: "+ ex);
        }
    }
}
