
package lab06abstractinterfaces;

public interface InterfaceA {

    default void hello() {
        System.out.println("Hello from Interface A");
    }
}
