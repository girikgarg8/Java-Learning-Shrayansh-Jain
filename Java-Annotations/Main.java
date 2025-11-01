import java.util.*;

@SuppressWarnings("unused")
//@SuppressWarnings("all")
public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String [] args) {
        Mobile mobile = new Mobile();
        mobile.dummyMethod();
        System.out.println(mobile.getClass().getAnnotation(MyCustomAnnotation.class));

        PaymentStrategy paymentStrategy = new UPIPaymentStrategy();
        paymentStrategy.pay(100);

        VarArgsDemo varArgsDemo = new VarArgsDemo();
        varArgsDemo.print();
        varArgsDemo.print("1");
        varArgsDemo.print("1","2");

        List <Integer> nums = List.of(1,2);
        varArgsDemo.func(nums);

        Mobile onePlusMobile = new OnePlusMobile();
        System.out.println(onePlusMobile.getClass().getAnnotation(MyCustomAnnotation.class));

        Eagle eagle = new Eagle();
        Category [] categoryAnnotationsArray = eagle.getClass().getAnnotationsByType(Category.class);
        for (Category annotation: categoryAnnotationsArray) {
            System.out.println(annotation.name());
        }
    }

    public void unusedMethod() {

    }
}
