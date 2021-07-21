package algorithmsAndDataStructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E extends Comparable<E>> {
    private E[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else {
            list = (E[]) new Comparable[capacity];
        }
    }

    public MyArrayList() {
        list = (E[]) new Comparable[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public int size() {
        return size;
    }

    public void add(E item) {
        if (capacity > size) {
            list[size] = item;
            size++;
        } else checkArraySize();
    }

    private void checkArraySize() {
        capacity = capacity + DEFAULT_CAPACITY / 2 + 1;
        E[] newList = (E[]) new Comparable[capacity];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    public void add(int index, E item) {
        if (index >= 0 & index <= size) {
            if (capacity > size) {
                for (int i = size; i > index; i--) {
                    list[i] = list[i - 1];
                }
                list[index] = item;
                size++;
            } else checkArraySize();
        } else throw new ArrayIndexOutOfBoundsException("index" + index + "is not correct ");
    }

    public boolean remove(E item) {
        int i = index(item);
        if (i == -1) {
            return false;
        } else removeIndex(i);
        return true;
    }

    public void removeIndex(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
        if (index >= 0 & index <= size) {
            for (int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }
            size--;
            list[size] = null;
        } else throw new ArrayIndexOutOfBoundsException("index" + index + "is not correct ");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index >= 0 & index < size) {
            return list[index];
        } else throw new ArrayIndexOutOfBoundsException("index" + index + "is not correct ");
    }

    public int indexOf(E item) {
        return index(item);
    }

    public boolean contains(E item) {
        return index(item) > -1;
    }

    private int index(E item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    private boolean less(E item1, E item2) {
        return (item1.compareTo(item2) < 0);
    }

    private void swap(int index1, int index2) {
        E temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        E key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }
}