package algorithmsAndDataStructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class MyQueue<T> {

    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public void insert(T item) {
        if (isFull()) {
            end = size;
            capacity = capacity + DEFAULT_CAPACITY / 2 + 1;
            T[] newArray1 = (T[]) new Object[capacity];
            System.arraycopy(list, 0, newArray1, 0, size);
            list = newArray1;
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove() {
        T temp = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return list[begin];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (end == begin) {
            for (int i = begin; i < size; i++) {
                sb.append(list[i]).append(",");
            }
        } else {
            for (int i = begin; i != end; i = nextIndex(i)) {
                sb.append(list[i]).append(", ");
            }
        }
        return sb.toString();

//         return Arrays.toString(Arrays.stream(list).filter(Objects::nonNull).toArray());
    }
}