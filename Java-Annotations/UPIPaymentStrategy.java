public class UPIPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying amount: " + amount + " by UPI");
    }
}
