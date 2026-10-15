
package lab11library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a registered library member.
public class Member {

    // Maximum number of items one member can borrow at a time.
    public static final int MAX_LOANS = 3;

    // Private fields protect the member's information.
    private final String id;
    private final String name;

    // Stores the items currently borrowed by this member.
    private final List<Loan> loans = new ArrayList<>();

    // Creates a member and validates the supplied details.
    public Member(String id, String name) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Member ID cannot be empty.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Member name cannot be empty.");
        }

        this.id = id.trim();
        this.name = name.trim();
    }

    // Returns the member's unique ID.
    public String getId() {
        return id;
    }

    // Returns the member's name.
    public String getName() {
        return name;
    }

    // Returns a read-only view of the member's active loans.
    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    // Checks whether the member has reached the loan limit.
    public boolean hasReachedLoanLimit() {
        return loans.size() >= MAX_LOANS;
    }

    // Adds a loan to the member's active loan list.
    // Package-private so the library classes can manage loans.
    void addLoan(Loan loan) {
        loans.add(loan);
    }

    // Removes a loan when the borrowed item is returned.
    void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    // Returns a readable description of the member.
    @Override
    public String toString() {
        return "Member ID: " + id
                + ", Name: " + name
                + ", Active loans: " + loans.size()
                + "/" + MAX_LOANS;
    }
}
