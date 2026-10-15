
package lab05polymorphism;

// Processes payments using runtime polymorphism
public class PolymorphicPaymentProcessor {

    public void pay(Payment payment) {
        payment.process();
    }
}
