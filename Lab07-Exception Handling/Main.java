
package lab07exceptionhandling;

public class Main {

    public static int testFinally() {

        try {
            System.out.println("Inside try block.");
            return 10;

        } finally {
            System.out.println("Inside finally block.");
        }
    }

    public static void main(String[] args) {

        int result = testFinally();

        System.out.println("Returned value: " + result);
    }
}
