package roundzero.day123;

import java.util.ArrayList;

/**
 * Created by Gaurav on 30/09/17.
 */
public class RearrangeArray {

    public static void main(String[] args) {
        RearrangeArray rearrangeArray = new RearrangeArray();
        ArrayList<Integer> inp = new ArrayList<>();
        inp.add(4);
        inp.add(0);
        inp.add(2);
        inp.add(1);
        inp.add(4);
        rearrangeArray.arrange(inp);
    }

    public void arrange(ArrayList<Integer> a) {


        for (int i = 0; i < a.size(); i++) {
            Integer no = a.get(i);

            a.set(i, a.get(no));

        }
        System.out.println(a);
    }
}
