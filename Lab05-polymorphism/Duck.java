
package lab05polymorphism;

// Duck inherits from Animal
public class Duck extends Animal {

    @Override
    public void sound() {
        System.out.println("Duck says: Quack!");
    }
}
