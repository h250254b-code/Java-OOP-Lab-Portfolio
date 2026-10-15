
package lab11library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Represents one borrowing transaction in the library.
public class Loan {

    // The item and member involved in the transaction.
    private final LibraryItem item;
    private final Member member;

    // Dates associated with the loan.
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    // Null means that the item has not yet been returned.
    private LocalDate returnDate;

    // Creates a new loan using today's date.
    public Loan(LibraryItem item, Member member) {

        this(item, member, LocalDate.now(),
                LocalDate.now().plusDays(
                        item.loanPeriodDays()), null);
    }

    // Creates a loan using saved dates from the CSV file.
    // This constructor is used when restoring existing records.
    Loan(LibraryItem item, Member member,
            LocalDate borrowDate, LocalDate dueDate,
            LocalDate returnDate) {

        // Validate all required objects and dates.
        if (item == null || member == null
                || borrowDate == null || dueDate == null) {
            throw new IllegalArgumentException(
                    "Item, member and loan dates are required.");
        }

        if (dueDate.isBefore(borrowDate)) {
            throw new IllegalArgumentException(
                    "Due date cannot be before the borrow date.");
        }

        this.item = item;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    // Returns the borrowed item.
    public LibraryItem getItem() {
        return item;
    }

    // Returns the member associated with the loan.
    public Member getMember() {
        return member;
    }

    // Returns the borrowing date.
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    // Returns the due date.
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Returns the actual return date, or null if still active.
    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Checks whether the loan is still active.
    public boolean isActive() {
        return returnDate == null;
    }

    // Checks whether an active loan has passed its due date.
    public boolean isOverdue() {
        return isActive() && LocalDate.now().isAfter(dueDate);
    }

    // Records the return date.
    public void markReturned() {
        if (isActive()) {
            returnDate = LocalDate.now();
        }
    }

    // Calculates how many days an active loan is overdue.
    public long daysOverdue() {
        if (!isOverdue()) {
            return 0;
        }

        return ChronoUnit.DAYS.between(
                dueDate, LocalDate.now());
    }

    // Returns a readable summary of the loan.
    @Override
    public String toString() {
        return "Item: " + item.getTitle()
                + ", Member: " + member.getName()
                + ", Borrowed: " + borrowDate
                + ", Due: " + dueDate
                + ", Returned: "
                + (returnDate == null
                ? "Not returned" : returnDate);
    }
}
