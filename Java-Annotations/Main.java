import java.util.*;

@SuppressWarnings("unused")
//@SuppressWarnings("all")
public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String [] args) {
        Mobile mobile = new Mobile();
        mobile.dummyMethod();

        PaymentStrategy paymentStrategy = new UPIPaymentStrategy();
        paymentStrategy.pay(100);
    }

    public void unusedMethod() {

    }
}
