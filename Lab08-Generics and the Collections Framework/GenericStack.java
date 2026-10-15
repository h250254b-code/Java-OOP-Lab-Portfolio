
package lab08collections;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class GenericStack<T> {

    private ArrayList<T> items = new ArrayList<>();

    // Add an item to the top of the stack
    public void push(T item) {
        items.add(item);
    }

    // Remove and return the top item
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        return items.remove(items.size() - 1);
    }

    // View the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        return items.get(items.size() - 1);
    }

    // Check whether the stack is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Return the number of items
    public int size() {
        return items.size();
    }
}
