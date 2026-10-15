
package lab04inheritance;

import java.util.ArrayList;

// Stack uses composition instead of extending ArrayList
public class MyStack<T> {

    // The list is private, so callers cannot access it directly
    private final ArrayList<T> items = new ArrayList<>();

    // Adds an item to the top of the stack
    public void push(T item) {
        items.add(item);
    }

    // Removes and returns the top item
    public T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return items.remove(items.size() - 1);
    }

    // Returns the top item without removing it
    public T peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return items.get(items.size() - 1);
    }

    // Checks whether the stack is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Returns the number of items in the stack
    public int size() {
        return items.size();
    }
}
