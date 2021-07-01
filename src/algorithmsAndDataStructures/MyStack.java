package algorithmsAndDataStructures;

import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack<E> {
    private int size;
    private E[] list;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else list = (E[]) new Objects[capacity];
    }

    public MyStack() {
        list = (E[]) new Objects[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
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
            E[]newList = (E[]) new Objects[capacity];
            System.arraycopy(list,0,newList,0,size);

        }
        list[size] = item;
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
