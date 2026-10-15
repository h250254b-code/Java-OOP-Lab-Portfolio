
package lab09enumsrecords;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size;

    // Private static nested Node class
    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }

    // Add an element to the end of the list
    public void add(T item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public int size() {
        return size;
    }

    // Inner Iterator class
    private class ListIterator implements Iterator<T> {

        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = (T) current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
}
