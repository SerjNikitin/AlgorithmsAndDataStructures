package algorithmsAndDataStructures;

public class MyLinkedStack<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E item) {
        list.insertFirst(item);
    }

    public E pop() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E pick() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean contains(E item) {
        return list.contains(item);
    }

    public String toString() {
        return list.toString();
    }
}
