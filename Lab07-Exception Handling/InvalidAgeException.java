
package lab07exceptionhandling;

// A checked exception for invalid ages
public class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}
