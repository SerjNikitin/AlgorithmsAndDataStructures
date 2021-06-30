package algorithmsAndDataStructures;

public class MyArraySortedList<E extends Comparable<E>> extends MyArrayList<E> {
    @Override
    public void add(E item) {
        int i = 0;
        while (i < size() && item.compareTo(get(i)) >= 0) {
            i++;
        }
        super.add(i, item);

    }

    @Override
    public void add(int index, E item) {
        add(item);
    }

    public int binaryFind(E item) {
        int x = 0;
        int y = size() - 1;
        while (x <= y) {
            int z = y + (x - y) / 2;
            if (item.compareTo(get(z)) > 0) {
                x = z + 1;
            } else if (item.compareTo(get(z)) < 0) {
                y = z - 1;
            } else return z;
        }
        return -1;
    }
}
