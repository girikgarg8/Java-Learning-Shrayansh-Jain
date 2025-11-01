import java.util.*;

public class SwitchDemo {
    public static void main(String [] args) {
        ProductType productType = ProductType.ELECTRONICS;
        String message = "hello";
        final String helloMessage = "hello";
        Integer outputValue = 1;
//        switch (productType) {
//            default:
//                System.out.println("Default product");
//            case GROCERY:
//                System.out.println("Grocery product");
//                break;
//            case ELECTRONICS:
//                System.out.println("Electronics product");
//        }

        switch (productType) {
            case ELECTRONICS, GROCERY :
                outputValue = 10;
                System.out.println("I am grocery or electronics product");
                switch(outputValue) {
                    case 10: System.out.println("I am value 10");
                }
                break;
            default: System.out.println("Default product");
        }

        String output = switch (productType) {
            case GROCERY -> "Grocery";
            case ELECTRONICS -> "Electronics";
            case FASHION -> "Fashion";
        };

        String output2 = switch (productType) {
            case GROCERY -> {
                // some business logic
                yield "Grocery";
            }
            case ELECTRONICS -> "Electronics";
            case FASHION -> "Fashion";
        };

        System.out.println("Output is " + output);
    }
}
