
package lab03encapsulation;

// Represents temperature using Kelvin internally
public class Temperature {

    // Private field prevents direct access to the stored value
    private final double kelvin;

    // Constructor validates the temperature
    public Temperature(double kelvin) {

        if (Double.isNaN(kelvin)
                || Double.isInfinite(kelvin)
                || kelvin < 0) {
            throw new IllegalArgumentException(
                    "Temperature cannot be below absolute zero.");
        }

        this.kelvin = kelvin;
    }

    // Converts Kelvin to Celsius
    public double getCelsius() {
        return kelvin - 273.15;
    }

    // Converts Kelvin to Fahrenheit
    public double getFahrenheit() {
        return (kelvin - 273.15) * 9.0 / 5.0 + 32;
    }
}
