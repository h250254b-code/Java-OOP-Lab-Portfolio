
package lab11library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Manages the library's items, members and borrowing transactions.
public class Library {

    // Store items in a Map using each item's ID as the key.
    private final Map<String, LibraryItem> items = new HashMap<>();

    // Store registered members using their IDs as the keys.
    private final Map<String, Member> members = new HashMap<>();

    // Keep a record of all loans, including returned loans.
    private final List<Loan> allLoans = new ArrayList<>();

    // Registers a new library item.
    public void addItem(LibraryItem item) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "Library item cannot be null.");
        }

        // Prevent duplicate item IDs.
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException(
                    "An item with this ID already exists.");
        }

        items.put(item.getId(), item);
    }

    // Registers a new member.
    public void registerMember(Member member) {

        if (member == null) {
            throw new IllegalArgumentException(
                    "Member cannot be null.");
        }

        // Prevent duplicate member IDs.
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException(
                    "A member with this ID already exists.");
        }

        members.put(member.getId(), member);
    }

    // Borrows an item for a registered member.
    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException,
                   MemberLimitExceededException {

        // Find the member and item using their IDs.
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);

        // Report an error if either record does not exist.
        if (member == null) {
            throw new IllegalArgumentException(
                    "Member not found: " + memberId);
        }

        if (item == null) {
            throw new IllegalArgumentException(
                    "Item not found: " + itemId);
        }

        // Do not allow borrowing an item that is already borrowed.
        if (!item.isAvailable()) {
            throw new ItemNotAvailableException(
                    "This item is currently unavailable.");
        }

        // Each member is allowed a maximum of three active loans.
        if (member.hasReachedLoanLimit()) {
            throw new MemberLimitExceededException(
                    "A member cannot have more than "
                    + Member.MAX_LOANS + " active loans.");
        }

        // Create a loan and update the relevant records.
        Loan loan = new Loan(item, member);

        member.addLoan(loan);
        item.setAvailable(false);
        allLoans.add(loan);
    }

    // Returns an item borrowed by a member.
    public void giveBack(String memberId, String itemId) {

        // Find the member and item.
        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);

        if (member == null) {
            throw new IllegalArgumentException(
                    "Member not found: " + memberId);
        }

        if (item == null) {
            throw new IllegalArgumentException(
                    "Item not found: " + itemId);
        }

        // Find the matching active loan.
        Loan matchingLoan = null;

        for (Loan loan : member.getLoans()) {
            if (loan.getItem().getId().equals(itemId)) {
                matchingLoan = loan;
                break;
            }
        }

        // A member cannot return an item they did not borrow.
        if (matchingLoan == null) {
            throw new IllegalArgumentException(
                    "This member has no active loan for that item.");
        }

        // Complete the return and update the item's availability.
        matchingLoan.markReturned();
        member.removeLoan(matchingLoan);
        item.setAvailable(true);
    }

    // Returns all items currently registered in the library.
    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(items.values());
    }

    // Returns all registered members.
    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    // Returns a copy of the complete loan history.
    public List<Loan> getAllLoans() {
        return new ArrayList<>(allLoans);
    }

    // Searches titles without case sensitivity using a stream.
    // Results are sorted alphabetically by title.
    public List<LibraryItem> searchByTitle(String text) {

        if (text == null) {
            throw new IllegalArgumentException(
                    "Search text cannot be null.");
        }

        String searchText = text.trim().toLowerCase();

        return items.values().stream()
                .filter(item -> item.getTitle()
                        .toLowerCase().contains(searchText))
                .sorted(Comparator.comparing(
                        LibraryItem::getTitle,
                        String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    // Finds loans that are overdue and have not been returned.
    public List<Loan> getOverdueLoans() {

        return allLoans.stream()
                .filter(Loan::isOverdue)
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    // Finds an item by its ID.
    public LibraryItem findItem(String itemId) {
        return items.get(itemId);
    }

    // Finds a member by their ID.
    public Member findMember(String memberId) {
        return members.get(memberId);
    }

    // Provides the items and members to the persistence component.
    // These methods return copies to protect the internal collections.
    public Map<String, LibraryItem> getItemsMap() {
        return new HashMap<>(items);
    }

    public Map<String, Member> getMembersMap() {
        return new HashMap<>(members);
    }

    // Adds a previously loaded loan to the loan history.
    // Used when restoring saved data from CSV files.
    void restoreLoan(Loan loan) {

        if (loan == null) {
            throw new IllegalArgumentException(
                    "Loan cannot be null.");
        }

        allLoans.add(loan);

        // Restore only loans that are still active.
        if (loan.isActive()) {
            loan.getMember().addLoan(loan);
            loan.getItem().setAvailable(false);
        }
    }
}
