
package lab06abstractinterfaces;

public class Aeroplane implements Flyable {

    @Override
    public void fly() {
        System.out.println("The aeroplane flies using its engines.");
    }
}
