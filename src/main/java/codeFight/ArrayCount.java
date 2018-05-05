package codeFight;

public class ArrayCount extends Array {
    private int count = 0;

    @Override
    public void add(Integer element) {
        super.add(element);
        ++count;
    }

    @Override
    public void addAll(int elements[]) {
        super.addAll(elements);
        count += elements.length;
    }

    public int getCount() {
        return count;
    }
}