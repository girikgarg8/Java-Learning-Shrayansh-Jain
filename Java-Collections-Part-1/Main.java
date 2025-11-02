import java.util.*;

public class Main {
    public static void main(String [] args) {
        List <Integer> numList = List.of(1,2,3);
        List <String> nameList = List.of("Girik", "Nikhil");

        Iterator <?> iterator = new MyListIterator<>(numList);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = new MyListIterator<>(nameList);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        int [] nums = {1,2,3};
        nums[0] = 5;
        System.out.println(nums[0]);

        Vector <Integer> vector = new Vector<>();
        vector.add(5);
        System.out.println(vector.get(0));


    }
}
