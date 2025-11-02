import java.util.*;

public class ComparatorDemo {
    public static void main(String [] args) {
        Integer [] arr = {2,4,34,1};
        Arrays.sort(arr);

        for (int num: arr) {
            System.out.println("Number is: " + num);
        }

        User john = new User(1, "John");
        User smith = new User(2, "Smith");

        User [] users = {john, smith};

//        Arrays.sort(users);

        Arrays.sort(arr, (Integer val1, Integer val2) -> val2-val1); // Providing concrete definition of the compare(obj1, obj2) method in Comparator functional interface

        for (int num: arr) {
            System.out.println("Value is: " + num);
        }

//        Arrays.sort(users, (User user1, User user2) -> user2.getId() - user1.getId());
//        Arrays.sort(users, (User user1, User user2) -> user2.getName().compareTo(user1.getName()));

        Arrays.sort(users, new MyUserComparator());

        for (User user: users) {
            System.out.println(user);
        }
    }
};