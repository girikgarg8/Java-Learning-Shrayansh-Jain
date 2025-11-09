public class SwitchPatternMatchDemo {
    public static void main(String [] args) {
        Object obj = "Hello";


        switch (obj) {
            case String str -> // internally, it is using instanceof pattern matching: obj instanceof String s
                System.out.println("Hi, I am the string "+ str);
            default ->
                System.out.println("Hi, I am not a string");
        }

        Object bikeObj = new Bike();

        switch (bikeObj) {
            case Vehicle vehicle:
                System.out.println("Hi I am a vehicle");
                break;
//            case Bike bike:
//                System.out.println("Hi I am a bike");
//                break;
//            case Cycle cycle:
//                System.out.println("Hi I am a cycle");
//                break;
            default:
                System.out.println("Hi, I am another object");
        }

        Object dayObj = Day.TUESDAY;

        switch (dayObj) {
            case Day day:
                System.out.println("Hi, I am the day: "+ day.name());
                break;
            default:
                System.out.println("Hello, I am not a day enum object");
        }

        // Built in null safety
        Object nullObject = null;
        switch (nullObject) {
            case String s:
                System.out.println("Hi, string: "+ s);
                break;
            case null:
                break;
            default:
                System.out.println("Hi, not a string");
        }

        Object strObject = "HelloWorld";

//        switch (strObject) {
//            case String s:
//                if (s.contains("H")) System.out.println("String with character H");
//            default:
//                System.out.println("Did not meet constraints");
//        }

        switch (strObject) {
            case String s when (s.contains("H")) -> System.out.println("String with character H");
            default -> System.out.println("Did not meet constraints");
        }

    }
}
