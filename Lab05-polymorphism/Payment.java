
package lab05polymorphism;

// Parent class for payment types
public abstract class Payment {
public abstract void process();
    protected double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Payment amount must be greater than zero.");
        }

        this.amount = amount;
    }
}
