
package lab03encapsulation;

// Tests temperature conversion and validation
public class Main {

    public static void main(String[] args) {

        // Creates a temperature of 300 Kelvin
        Temperature temperature = new Temperature(300.0);

        // Uses public methods instead of accessing internal storage
        System.out.printf("Celsius: %.2f °C%n",
                temperature.getCelsius());

        System.out.printf("Fahrenheit: %.2f °F%n",
                temperature.getFahrenheit());

        // Tests rejection of a temperature below absolute zero
        try {
            Temperature invalid = new Temperature(-5.0);
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Invalid temperature rejected: "
                    + e.getMessage());
        }

        // The caller depends on the public methods, not the field
        System.out.println(
                "Temperature conversions use the public API.");
    }
}
