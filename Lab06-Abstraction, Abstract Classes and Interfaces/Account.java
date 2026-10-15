
package lab06abstractinterfaces;

public abstract class Account {

    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // Concrete method shared by all account types
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Each account type defines its own monthly fee
    public abstract double monthlyFee();

    public double getBalance() {
        return balance;
    }
}
