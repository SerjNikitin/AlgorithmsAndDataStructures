package algorithmsAndDataStructures;

import java.util.Arrays;


public class MyQueue<E> {
    private int size;
    private E[] list;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;
    private int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        } else list = (E[]) new Object[capacity];
    }

    public MyQueue() {
        list = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public E peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list[begin];
    }

    public void insertRight(E item) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public int nextIndex(int index) {
        return (index + 1) % list.length;

    }
    public int prevIndex(int index){
        if (index==0){
            return list.length-1;
        }return index-1;

    }


    public void insertLeft(E item) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }

        size++;
        list[prevIndex(begin)] = item;
        begin=prevIndex(begin);

    }

    public E peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list[end-1];
    }

    public E removeLeft() {
        E temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public E removeRight() {
        E temp = peekRight();
        size--;
        list[end-1] = null;
        end = nextIndex(begin);
        return temp;
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

    //    @Override
//    public String toString() {
//        return Arrays.toString(Arrays.copyOf(list, size)) + " b = " + begin + " e = " + end;
//    }
    @Override
    public String toString() {
        return Arrays.toString(list) + " b = " + begin + " e = " + end;
    }

}