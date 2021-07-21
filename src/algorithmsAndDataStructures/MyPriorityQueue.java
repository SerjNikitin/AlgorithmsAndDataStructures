package algorithmsAndDataStructures;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyPriorityQueue<E extends Comparable> {
    private int size;
    private E[] list;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else list = (E[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        list = (E[]) new Comparable[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public void insert(E item) {
        if (isFull()) {
            capacity = capacity + DEFAULT_CAPACITY / 2 + 1;
            E[] newArray = (E[]) new Comparable[capacity];
            System.arraycopy(list, 0, newArray, 0, size);
            list=newArray;
        }
        list[size] = item;
        size++;
        int i = size - 1;
        while (i > 0 && list[i].compareTo(list[i - 1]) > 0) {
            swap(i, i - 1);
            i--;
        }
    }

    private void swap(int index1, int index2) {
        E temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public E remove() {
        E temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
