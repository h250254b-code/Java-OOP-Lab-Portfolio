package lab11library;

// Abstract parent class for books and DVDs.
// Implements the Borrowable interface.
public abstract class LibraryItem implements Borrowable {

    private final String id;
    private final String title;
    private boolean available;

    public LibraryItem(String id, String title) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Item ID cannot be empty.");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Title cannot be empty.");
        }

        this.id = id.trim();
        this.title = title.trim();
        this.available = true;
    }

    // Each item type defines its own loan period.
    public abstract int loanPeriodDays();

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Implements the borrowing operation required by Borrowable.
    @Override
    public void borrow(Member member) {

        if (member == null) {
            throw new IllegalArgumentException(
                    "Member cannot be null.");
        }

        if (!available) {
            throw new IllegalStateException(
                    "This item is already borrowed.");
        }

        if (member.hasReachedLoanLimit()) {
            throw new IllegalStateException(
                    "Member has reached the borrowing limit.");
        }

        Loan loan = new Loan(this, member);
        member.addLoan(loan);
        available = false;
    }

    // Marks the item as available when returned.
    @Override
    public void giveBack() {

        if (available) {
            throw new IllegalStateException(
                    "This item is not currently borrowed.");
        }

        available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Title: " + title
                + ", Type: " + getClass().getSimpleName()
                + ", Loan period: " + loanPeriodDays() + " days"
                + ", Available: " + available;
    }
}