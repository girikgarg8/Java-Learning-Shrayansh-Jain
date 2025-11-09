import java.util.*;

public sealed interface PaymentStrategy permits UPIPaymentStrategy, DebitCardPaymentStrategy {
    public void pay(double amount);
}
