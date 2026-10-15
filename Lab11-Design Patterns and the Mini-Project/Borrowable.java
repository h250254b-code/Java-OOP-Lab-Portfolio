
package lab11library;

// Defines the operations required for an item
// that can be borrowed and returned.
public interface Borrowable {

    // Borrows an item for the specified library member.
    void borrow(Member member);

    // Returns the borrowed item to the library.
    void giveBack();
}
