/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ProBook
 */
// Represents a person who has an address
public class Person {

    // Stores the person's name
    String name;

    // Stores a reference to the person's address
    Address address;

    // Initializes the person's name and address
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
