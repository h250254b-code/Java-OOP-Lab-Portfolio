
package lab05polymorphism;

// Cat inherits from Animal
public class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("Cat says: Meow!");
    }
}
