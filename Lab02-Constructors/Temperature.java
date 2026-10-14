/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01classesandobjects;

/**
 *
 * @author ProBook
 */
// Represents temperature internally in Celsius
public class Temperature {

    // Stores the temperature in Celsius
    private double celsius;

    // Private constructor prevents direct object creation from outside
    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Factory method creates a Temperature from Celsius
    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius);
    }

    // Factory method converts Fahrenheit to Celsius before creating an object
    public static Temperature fromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return new Temperature(celsius);
    }

    // Returns the temperature in Celsius
    public double getCelsius() {
        return celsius;
    }

    // Converts Celsius to Fahrenheit and returns the result
    public double getFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Displays the temperature in both units
    public void display() {
        System.out.printf("Celsius: %.2f°C%n", getCelsius());
        System.out.printf("Fahrenheit: %.2f°F%n", getFahrenheit());
        System.out.println("--------------------");
    }
}