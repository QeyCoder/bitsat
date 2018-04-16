package day68;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MovingTotal {
    List<Integer> container;
    Set<Integer> sum;


    public MovingTotal() {


        container = new ArrayList<>();
        sum = new HashSet<>();


    }

    /**
     * Adds/appends list of integers at the end of internal list.
     */
    public void append(int[] list) {

        for (int i = 0; i < list.length; i++) {
            container.add(list[i]);
        }



            for (int j = 2; j < container.size(); j++) {



            sum.add(container.get(j-2)+container.get(j-1)+container.get(j));
        }


    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        return sum.contains(total);
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[]{1, 2, 3});
        movingTotal.append(new int[]{4});
        movingTotal.append(new int[]{100,200,500});
        System.out.println(movingTotal.contains(800));
        System.out.println(movingTotal.contains(6));

        System.out.println(movingTotal.contains(9));



        System.out.println(movingTotal.contains(9));
    }
}