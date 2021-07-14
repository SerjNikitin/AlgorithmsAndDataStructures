package algorithmsAndDataStructures;

public class Main {

    public static void main(String[] args) {

        doTask2();
//        System.out.println(recursFib(5));
//        System.out.println(recurs(5));
//        System.out.println(doTask(5, -2));
//        System.out.println(recTriangleNum(5));
    }

    public static double doTask1(double x, int y) {
        if (y == 1) {
            return x;
        }
        if (y == 0) {
            return 1;
        }
        if (y < 0) {
            return 1 / x * doTask1(x, ++y);
        }
        return doTask1((x * x), y - 1);
    }

    public static void doTask2() {
        Item[] items = new Item[]{
                new Item(5, 7),
                new Item(10, 7),
                new Item(3, 2)
        };
        Backpack backpack = new Backpack(items);
        int sizeBag = 10;
        System.out.println(backpack.put(items.length - 1, sizeBag));
    }

    public static int recurs(int n) {
        if (n == 1) {
            return n;
        }
        return recurs(n - 1) * n;
    }

    public static int recursFib(int n) {
        if (n < 3) {
            return 1;
        }
        return recursFib(n - 1) + recursFib(n - 2);
    }

    public static int recTriangleNum(int n) {
        System.out.println(n);
        if (n == 1) {
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }
}