/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01classesandobjects;

/**
 *
 * @author ProBook
 */
// Demonstrates the execution order of initialization blocks
public class InitializationDemo {

    // First static block runs once when the class is loaded
    static {
        System.out.println("First static block");
    }

    // Second static block also runs once when the class is loaded
    static {
        System.out.println("Second static block");
    }

    // First instance block runs whenever an object is created
    {
        System.out.println("First instance block");
    }

    // Second instance block runs after the first instance block
    {
        System.out.println("Second instance block");
    }

    // Constructor runs after the instance initialization blocks
    public InitializationDemo() {
        System.out.println("Constructor");
    }

    // Main method starts the program
    public static void main(String[] args) {

        // Creates the first object
        System.out.println("Creating first object:");
        InitializationDemo obj1 = new InitializationDemo();

        // Creates the second object
        System.out.println("Creating second object:");
        InitializationDemo obj2 = new InitializationDemo();
    }
}

