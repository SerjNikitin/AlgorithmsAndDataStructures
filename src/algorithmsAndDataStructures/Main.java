package algorithmsAndDataStructures;


public class Main {

    public static void main(String[] args) {
//        stack();
//        queue();
        list();

    }

    public static void stack() {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pick());
    }

    public static void queue() {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        queue.insert(11);
        queue.insert(22);
        queue.insert(33);
        queue.insert(44);
        System.out.println(queue.toString());
        System.out.println(queue.contains(22));
        System.out.println(queue.getLast());
    }

    public static void list() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        System.out.println(list);
    }
}
