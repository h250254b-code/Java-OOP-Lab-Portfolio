/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01classesandobjects;

/**
 *
 * @author ProBook
 */
// Tests the Temperature class and its factory methods
public class Main {

    public static void main(String[] args) {

        // Creates a temperature using Celsius
        Temperature temp1 = Temperature.fromCelsius(25.0);

        // Creates a temperature using Fahrenheit
        Temperature temp2 = Temperature.fromFahrenheit(98.6);

        // Displays both temperature objects
        System.out.println("Temperature created from Celsius:");
        temp1.display();

        System.out.println("Temperature created from Fahrenheit:");
        temp2.display();
    }
}
