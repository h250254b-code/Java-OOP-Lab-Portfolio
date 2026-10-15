
package lab05polymorphism;

// Processes payments by checking their concrete types
public class PaymentProcessor {

    public void pay(Payment payment) {

        if (payment instanceof CardPayment card) {
            card.process();

        } else if (payment instanceof MobileMoneyPayment mobile) {
            mobile.process();

        } else {
            throw new IllegalArgumentException(
                    "Unsupported payment type.");
        }
    }
}
