
package lab03encapsulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a bank account with transaction history
public class BankAccount {

    // Stores the current account balance
    private double balance;

    // Stores transaction descriptions privately
    private final List<String> transactions = new ArrayList<>();

    // Constructor initializes the account balance
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative.");
        }

        balance = initialBalance;
        transactions.add("Account opened with balance: "
                + initialBalance);
    }

    // Returns the current balance
    public double getBalance() {
        return balance;
    }

    // Deposits money and records the transaction
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit must be greater than zero.");
        }

        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    // Withdraws money if sufficient funds are available
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient funds.");
        }

        balance -= amount;
        transactions.add("Withdrew: " + amount);
    }

    // Returns an unmodifiable copy of the transaction history
    public List<String> getTransactions() {
        return Collections.unmodifiableList(
                new ArrayList<>(transactions));
    }
}
