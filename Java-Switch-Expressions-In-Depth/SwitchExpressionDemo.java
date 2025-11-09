import java.util.*;

public class SwitchExpressionDemo {
    public static void main(String [] args) {
        Day day = Day.THURSDAY;
//        switch (day) {
//            case MONDAY:
//            case TUESDAY:
//            case WEDNESDAY: System.out.println("Hello, world!");
//        }

        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY -> System.out.println("Hi");
            case THURSDAY -> System.out.println("Good");
            default -> System.out.println("Hello");
        }

        int count = switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY -> 0;
            case THURSDAY -> {
                System.out.println("Executing the thursday case");
                yield 1;
            }
            default -> 2;
        };

        System.out.println("Count is: " + count);


//        switch (day) {
//            case MONDAY: {
//                String returnVal = "Monday";
//            }
//
//            case TUESDAY: {
//                String returnVal = "Tuesday";
//            }
//        }

         switch(day) {
            case MONDAY, TUESDAY, WEDNESDAY -> {
                System.out.println("First three days");
                String returnVal = "5";
            }

            default -> {
                String returnVal = "6";
            }
        };

         String typeOfDay = switch(day) {
             case SATURDAY, SUNDAY:
                 yield "Weekend";
             default:
                 yield "Weekday";
         };

         System.out.println("Type of day is: "+ typeOfDay);
    }
};