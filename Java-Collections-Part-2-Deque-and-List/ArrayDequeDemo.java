import java.util.*;

public class ArrayDequeDemo {
  public static void main(String [] args) {
      Deque <Integer> arrayDequeAsQueue = new ArrayDeque<>();
      //Insertion
      arrayDequeAsQueue.addLast(1);
      arrayDequeAsQueue.addLast(2);
      arrayDequeAsQueue.addLast(3);

      // Deletion
      Integer element = arrayDequeAsQueue.removeFirst();
      System.out.println("Element is: " + element);

      Deque <Integer> arrayDequeAsStack = new ArrayDeque<>();
      // Insertion
      arrayDequeAsStack.addFirst(1);
      arrayDequeAsStack.addFirst(2);
      arrayDequeAsStack.addFirst(3);

      // Deletion
      Integer removedElement = arrayDequeAsQueue.removeFirst();
      System.out.println("Removed element is: " + removedElement);

      // Insertion and deletion in deque are amortized O(1) -> to read how, visit https://stackoverflow.com/questions/64847932/does-arraydeque-have-overhead-of-shifting-elements-on-remove-add
  }
};