package algorithmsAndDataStructures;

import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<E> {
    private int size;
    private E[] list;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else list = (E[]) new Objects[capacity];
    }

    public MyStack() {
        list = (E[]) new Objects[DEFAULT_CAPACITY];
    }

    public E pick() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }
    public void push(E item){
        if (isFull()) {

        } list[size]=item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size == list.length;
    }
}
