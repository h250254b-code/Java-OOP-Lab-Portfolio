
package lab04inheritance;

// Tests the stack implemented using composition
public class Main {

    public static void main(String[] args) {

        MyStack<String> stack = new MyStack<>();

        // Adds three items
        stack.push("Book");
        stack.push("Laptop");
        stack.push("Phone");

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top item: " + stack.peek());

        // Removes items in LIFO order
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());

        System.out.println("Is stack empty: " + stack.isEmpty());
    }
}
