package algorithmsAndDataStructures;

public class Backpack {
    private Item[] item;

    public Backpack(Item[] item) {
        this.item = item;

    }

    public int put(int i, int weight) {
        if (i < 0) {
            return 0;
        }
        if (item[i].getWeight() > weight) {
            return put(i - 1, weight);

        } else return Math.max(put(i - 1, weight),
                put(i - 1, weight - item[i].getWeight()) + item[i].getPrice());
    }
}