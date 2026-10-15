
package lab07exceptionhandling;

public class AgeValidator {

    public static void validateAge(int age)
            throws InvalidAgeException {

        if (age < 0 || age > 120) {
            throw new InvalidAgeException(
                    "Age must be between 0 and 120."
            );
        }

        System.out.println("Valid age: " + age);
    }
}
