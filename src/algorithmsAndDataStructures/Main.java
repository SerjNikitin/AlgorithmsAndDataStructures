package algorithmsAndDataStructures;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        doTask();

        long startTimeCreate = System.currentTimeMillis();
        Random random = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            mal.add(random.nextInt(100000));
        }
        System.out.println(System.currentTimeMillis() - startTimeCreate);
        selectionSort(mal);

    }

    public static void selectionSort(MyArrayList<Integer> mal) {
        long startTimeSel = System.currentTimeMillis();
        mal.selectionSort();
        System.out.printf("selectionSort: %s ", System.currentTimeMillis() - startTimeSel);
    }

    public static void insertionSort(MyArrayList<Integer> mal) {
        long startTimeIns = System.currentTimeMillis();
        mal.insertionSort();
        System.out.printf("insertionSort: %s ", System.currentTimeMillis() - startTimeIns);
    }

    public static void bubbleSort(MyArrayList<Integer> mal) {
        long startTimeBub = System.currentTimeMillis();
        mal.bubbleSort();
        System.out.printf("bubbleSort: %s", System.currentTimeMillis() - startTimeBub);
    }


    public static void doTask() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        list.add(10, 66);
        list.add(5, 66);
        list.add(6, 66);
        list.add(10, 66);
        list.add(11, 66);
        list.add(8, 66);
        System.out.println(list);
    }
}