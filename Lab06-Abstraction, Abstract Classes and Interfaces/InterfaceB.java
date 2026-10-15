
package lab06abstractinterfaces;

public interface InterfaceB {

    default void hello() {
        System.out.println("Hello from Interface B");
    }
}
