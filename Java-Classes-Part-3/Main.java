import java.util.*;

public class Main {
    public static void main(String [] args) {
        // Usage of values() and ordinal()
        for (EnumSample enumSample: EnumSample.values()) {
            System.out.println("Ordinal value for " + enumSample.name() + " is " + enumSample.ordinal());
        }

        // usage of valueOf() and name()
        EnumSample enumSample = EnumSample.valueOf("TUESDAY");
        System.out.println("Name is " + enumSample.name());

        EnumSample fridaySample = EnumSample.getByComment("Hello, I am Friday");
        System.out.println("Enum Sample is : " + fridaySample.name());
        fridaySample.dummyMethod();
        fridaySample.greet();

        EnumSample thursdaySample = EnumSample.THURSDAY;
        thursdaySample.dummyMethod();
        thursdaySample.greet();
        System.out.println("Thursday lowercase is: "+ thursdaySample.toLowerCase());
    }
}