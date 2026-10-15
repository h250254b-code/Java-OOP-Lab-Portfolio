
package lab04inheritance;

// Parent class containing common person details
public class Person {

    protected String name;
    protected int age;

    // Constructor initializes the person's details
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Displays common person information
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
