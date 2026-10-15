
package lab11library;

// Custom exception thrown when a member tries to exceed
// the maximum number of active loans.
public class MemberLimitExceededException extends Exception {

    // Creates the exception with a helpful error message.
    public MemberLimitExceededException(String message) {
        super(message);
    }
}
