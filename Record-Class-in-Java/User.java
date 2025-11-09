import java.util.*;

public record User (String id, String name, List <String> names) {
    public static final Integer COUNT = 50;

//    public User(String id, String name) {
//        if (id.equals("0")) throw new IllegalArgumentException("Id cannot be zero");
//        this.id = id;
//        this.name = name;
//    }

    // below is compact constructor, which is shorthand of canonical constructor
    public User {
        if (id.equals("0")) throw new IllegalArgumentException("Id cannot be zero");
        names = List.copyOf(names);
        //compiler does this.id = id and this.name = name automatically
    }

    public User(String name) {
        this("1", name, new ArrayList<>());
    }

    @Override
    public String id() {
        System.out.println("Getting the id");
        return id;
    }

    @Override
    public String toString() {
        System.out.println("Getting the toString implementation");
        return "Id: "+ this.id + " name: " + this.name;
    }

    // only static nested records are allowed, non-static nested records are not allowed
    record Nested (String id, String phone) {

    }

    static class NestedStaticClass {
        public void display() {
            System.out.println("Hello from nested static class");
        }
    }

    class NonStaticNestedClass {
        public void display() {
            System.out.println("Hello from nested non static class");
        }
    }
}
