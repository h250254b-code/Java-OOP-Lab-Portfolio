
package lab11library;

// Custom exception thrown when an item cannot be borrowed.
public class ItemNotAvailableException extends Exception {

    // Creates the exception with a helpful error message.
    public ItemNotAvailableException(String message) {
        super(message);
    }
}
