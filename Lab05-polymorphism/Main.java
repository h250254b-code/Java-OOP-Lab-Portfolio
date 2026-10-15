
package lab05polymorphism;

// Compares instanceof and polymorphic payment processing
public class Main {

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(50.00, "1234567812345678"),
            new MobileMoneyPayment(25.00, "+263771234567")
        };

        System.out.println("DESIGN 1: INSTANCEOF");

        PaymentProcessor processor = new PaymentProcessor();

        for (Payment payment : payments) {
            processor.pay(payment);
        }

        System.out.println();
        System.out.println("DESIGN 2: POLYMORPHISM");

        PolymorphicPaymentProcessor polymorphicProcessor =
                new PolymorphicPaymentProcessor();

        for (Payment payment : payments) {
            polymorphicProcessor.pay(payment);
        }
    }
}
