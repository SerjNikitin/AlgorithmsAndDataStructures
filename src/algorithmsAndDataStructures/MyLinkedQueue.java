package algorithmsAndDataStructures;

public class MyLinkedQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void insert(E item) {
        list.insertFirst(item);
    }

    public E remove() {
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E getFirst() {
        return list.getFirst();
    }

    public E getLast() {
        return list.getLast();
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
