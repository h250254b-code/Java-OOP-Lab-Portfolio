
package lab06abstractinterfaces;

public class Greeting implements InterfaceA, InterfaceB {

    @Override
    public void hello() {
        System.out.println("Resolving the default method conflict:");

        InterfaceA.super.hello();
        InterfaceB.super.hello();
    }
}
