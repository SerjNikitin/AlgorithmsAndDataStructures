package algorithmsAndDataStructures;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        doTask();
//        queue();
        priorityQueue();
    }

    public static void priorityQueue() {
        MyPriorityQueue<Integer> queue = new MyPriorityQueue<>();
        queue.insert(10);
        queue.insert(1);
        queue.insert(5);
        queue.insert(4);
        queue.insert(0);
        queue.insert(-1);
        queue.insert(-1);
        queue.insert(-1);
        queue.insert(-1);
        queue.insert(-1);
        queue.insert(-1);
        queue.insert(-1);

        System.out.println(queue);
        System.out.println(queue.remove());

    }

    public static void queue() {
        MyDequeue<Integer> queue = new MyDequeue<>();
        queue.insertRight(1);
        queue.insertRight(2);
        queue.insertRight(3);
        queue.insertRight(4);
        queue.insertRight(5);

        queue.insertLeft(6);
        queue.insertLeft(7);
        queue.insertLeft(8);
        queue.insertLeft(9);
        queue.insertLeft(10);

        System.out.println("left " + queue.peekLeft());
        System.out.println("right " + queue.peekRight());
        System.out.println(queue);
        System.out.println(queue.removeLeft());
        System.out.println(queue);
        System.out.println(queue.removeRight());
        System.out.println(queue);

//
//        System.out.println(queue);
//
//
//        System.out.println(queue.remove());
//
//        System.out.println(queue);
//
//        queue.insertRate(5);
//
//        System.out.println(queue);
//        queue.insertLeft(12);
//        System.out.println(queue);

    }

    public static void stack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        System.out.println(stack);
    }

    public static void doTask() {
        Scanner scanner = new Scanner(System.in);
        MyStack<String> stack = new MyStack<>();
        while (true) {
            String s = scanner.nextLine();
            String[] split = s.split("");
            for (int i = 0; i < split.length; i++) {
                stack.push(split[i]);
            }
            for (int i = stack.size(); i > 0; i--) {
                System.out.print(stack.pop());
            }
        }
    }
}
