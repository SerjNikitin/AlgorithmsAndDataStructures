package algorithmsAndDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private Node first;
    private int size;
    private Node last;

    public void insertFirst(E item) {
        Node newNode = new Node(first, item);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(E item) {
        Node newNode = new Node(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else last.setNext(newNode);
        last = newNode;
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

        if (index == size) {
            insertLast(item);
            return;
        }
        Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(current, item, current.getNext());
        current.setNext(newNode);
        newNode.getNext().setPrev(newNode);
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
        while (current != null && !current.value.equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;

    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        E temp = first.getValue();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        E temp = last.getValue();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        return first.getValue();
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is Empty");
        }
        return last.getValue();
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

    @Override
    public Iterator<E> iterator() {
        return new Iterate();
    }

    private class Iterate implements Iterator<E> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.value;
            current = current.getNext();
            return e;
        }
    }

    private class Node {
        Node prev;
        E value;
        Node next;

        public Node(Node prev, E value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node(Node next, E value) {
            this.next = next;
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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