package roundzero.codeFight;


import java.util.ArrayList;

public class Array {
    private ArrayList<Integer> a = new ArrayList<Integer>();

    public void add(Integer element) {
        a.add(element);
    }

    public void addAll(int elements[]) {
        for (int i = 0; i < elements.length; ++i)
//            a.add(elements[i]); // this line is going to be changed
            add(elements[i]); // this line is going to be changed
    }
}
