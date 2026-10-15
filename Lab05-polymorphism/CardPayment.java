
package lab05polymorphism;

// Represents a card payment
public class CardPayment extends Payment {

    private String cardNumber;

    public CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
@Override
    public void process() {
        System.out.printf(
                "Card payment of $%.2f processed using card ending %s.%n",
                amount,
                cardNumber.substring(cardNumber.length() - 4));
    }
}
