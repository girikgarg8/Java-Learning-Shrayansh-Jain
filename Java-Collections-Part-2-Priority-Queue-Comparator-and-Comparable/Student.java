import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public int compareTo(Student other) {
        return this.rollNumber - other.rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + " roll number: " + rollNumber;
    }
}
