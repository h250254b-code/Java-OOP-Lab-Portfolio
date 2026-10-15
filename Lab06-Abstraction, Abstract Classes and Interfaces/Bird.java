
package lab06abstractinterfaces;

public class Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("The bird flies by flapping its wings.");
    }
}
