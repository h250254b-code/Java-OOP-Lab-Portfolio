
package lab04inheritance;

// Dog inherits from Animal
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        System.out.println("Dog constructor called.");
    }

    public void display() {
        System.out.println("Animal name: " + name);
    }
}
