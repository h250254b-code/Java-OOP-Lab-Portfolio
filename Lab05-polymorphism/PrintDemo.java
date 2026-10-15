
package lab05polymorphism;

import java.util.Arrays;

// Demonstrates method overloading
public class PrintDemo {

    // Accepts an integer
    public void print(int number) {
        System.out.println("Integer: " + number);
    }

    // Accepts a decimal number
    public void print(double number) {
        System.out.println("Double: " + number);
    }

    // Accepts a string
    public void print(String text) {
        System.out.println("String: " + text);
    }

    // Accepts an array of integers
    public void print(int[] numbers) {
        System.out.println(
                "Integer array: " + Arrays.toString(numbers));
    }
}
