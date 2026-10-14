/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ProBook
 */
// Main class to test composition and null references
public class Main {

    public static void main(String[] args) {

        // Creates an address object
        Address address = new Address("Harare");

        // Creates a person with an address
        Person person = new Person("Tendai", address);

        // Accesses the city using chained dot notation
        System.out.println("Person's city: " + person.address.city);

        // Creates a person whose address is null
        Person personWithoutAddress = new Person("Tariro", null);

        // Handles the missing address safely
        if (personWithoutAddress.address != null) {
            System.out.println("City: " + personWithoutAddress.address.city);
        } else {
            System.out.println("Address is not available.");
        }
    }
}
