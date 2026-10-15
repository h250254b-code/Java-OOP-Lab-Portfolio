
package lab05polymorphism;

// Represents a mobile money payment
public class MobileMoneyPayment extends Payment {

    private String phoneNumber;

    public MobileMoneyPayment(double amount, String phoneNumber) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }
@Override
    public void process() {
        System.out.printf(
                "Mobile money payment of $%.2f processed for %s.%n",
                amount, phoneNumber);
    }
}
