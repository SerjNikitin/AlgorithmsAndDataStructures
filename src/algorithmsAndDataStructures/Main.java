package algorithmsAndDataStructures;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        final int count = 100000;
        int isBalance = 0;

        for (int i = 0; i < count; i++) {
            MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
            while (treeMap.height() < 6) {
                treeMap.put(ThreadLocalRandom.current().nextInt(-100, 100),
                        ThreadLocalRandom.current().nextInt(0, 100));
            }
            System.out.println(treeMap);

            if (treeMap.isBalance())
                isBalance++;
        }
        System.out.println("Total wood: " + count +
                ", balanced wood: " + isBalance +
                ", not balanced wood: " + (count - isBalance));
    }
}