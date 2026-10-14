/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ProBook
 */
// Represents a car and stores its details
public class Car {

    // Instance fields that store the car's information
    String brand;
    int year;
    double mileage;

    // Constructor initializes a new Car object
    public Car(String brand, int year, double mileage) {
        this.brand = brand;       // Stores the car's brand
        this.year = year;         // Stores its manufacturing year
        this.mileage = mileage;   // Stores its mileage
    }

    // Displays the details of the car
    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage + " km");
        System.out.println("--------------------");
    }

    // Checks whether the car is more than 25 years old
    public boolean isAntique() {

        // Gets the current year from the system date
        int currentYear = java.time.Year.now().getValue();

        // Calculates the car's age
        int age = currentYear - year;

        // Returns true if the car is older than 25 years
        return age > 25;
    }
}
