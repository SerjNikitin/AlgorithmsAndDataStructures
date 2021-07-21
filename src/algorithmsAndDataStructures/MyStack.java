package algorithmsAndDataStructures;

import java.util.Arrays;
import java.util.EmptyStackException;


public class MyStack<E> {
    private int size;
    private E[] list;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else list = (E[]) new Object[capacity];
    }

    public MyStack() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public E pop() {
        E temp = pick();
        size--;
        list[size] = null;
        return temp;
    }

    public E pick() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public void push(E item) {
        if (isFull()) {
            capacity = capacity + DEFAULT_CAPACITY / 2 + 1;
            E[] newList = (E[]) new Object[capacity];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
        }
        list[size] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
