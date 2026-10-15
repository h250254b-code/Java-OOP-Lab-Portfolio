
package lab05polymorphism;

// Child class hides the parent's field and overrides its method
public class Child extends Parent {

    public String message = "Child field";

    @Override
    public void display() {
        System.out.println("Child method");
    }
}
