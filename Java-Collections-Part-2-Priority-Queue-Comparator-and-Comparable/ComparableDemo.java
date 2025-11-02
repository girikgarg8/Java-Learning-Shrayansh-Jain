import java.util.*;

public class ComparableDemo {
    public static void main(String [] args) {
        Student john = new Student("John", 2);
        Student smith = new Student("Smith", 1);

        Student [] students = {john, smith};

        Arrays.sort(students);

        for (Student student: students) {
            System.out.println(student);
        }
    }
}