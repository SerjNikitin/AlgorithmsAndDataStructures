package algorithmsAndDataStructures;

import java.util.NoSuchElementException;

public class MyLinkedListOneLink<E> {

    private Node first;
    private int size;

    public void insertFirst(E item) {
        Node node = new Node(first, item);
        first = node;
        size++;
    }

    public void insert(E item, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node node = new Node(current.getNext(), item);
        current.setNext(node);
        size++;
    }

    public boolean remove(E item) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        if (item.equals(first.value)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current.getNext() != null && !current.getNext().value.equals(item)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return false;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;

    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        E temp = first.getValue();
        first = first.getNext();
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node getFirst() {
        return first;
    }

    public int size() {
        return size;
    }

    public boolean contains(E item) {
        return index(item) > -1;
    }

    public int indexOf(E item) {
        return index(item);
    }

    private int index(E item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = first;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    private class Node {
        Node next;
        E value;

        public Node(Node next, E value) {
            this.next = next;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
