/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ProBook
 */
// Represents a rectangle using its width and height
public class Rectangle {

    // Instance fields store the rectangle's dimensions
    double width;
    double height;

    // Constructor initializes a rectangle with its dimensions
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Calculates and returns the rectangle's area
    public double area() {
        return width * height;
    }

    // Calculates and returns the rectangle's perimeter
    public double perimeter() {
        return 2 * (width + height);
    }
}

