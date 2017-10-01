import java.util.ArrayList;
import java.util.List;

class Stack {

    List<Integer> a = new ArrayList<>();
    int current = 0;
    int initial = 10;
    int threshold = 75;

    public Stack() {

    }

    public void push(int x) {
        a.add(current++, x);

    }

    public void pop() {
        if (current >= 0) {
            current--;
        }

    }

    public int top() {
        if (current >= 0) {
            return a.get(current);
        }
        return -1;
    }

    public int getMin() {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < current; i++) {
            if (a.get(i) < min) {
                min = a.get(current);
            }

        }
        return min;
    }
}
