/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01classesandobjects;

/**
 *
 * @author ProBook
 */
// Represents a circle and counts the circles created
public class Circle {

    // Stores the radius for each individual circle
    double radius;

    // Shared counter belonging to the Circle class
    private static int circleCount = 0;

    // No-argument constructor sets radius to 1.0
    public Circle() {
        radius = 1.0;
        circleCount++;
    }

    // Constructor accepts a specified radius
    public Circle(double radius) {
        this.radius = radius;
        circleCount++;
    }

    // Static getter returns the number of circles created
    public static int getCircleCount() {
        return circleCount;
    }

    // Calculates the area of the circle
    public double area() {
        return Math.PI * radius * radius;
    }

    // Displays the circle's radius and area
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
        System.out.println("--------------------");
    }
}