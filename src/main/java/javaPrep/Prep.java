package javaPrep;

/**
 * Created by Gaurav on 10/04/18.
 */


public class Prep {

    {
        index = 1;
    }

    int index;

    public static void main(String[] args) {
        new Prep().go();
    }

    void go() {

        int[][] dd = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1, 0}};
        System.out.println(dd[index++][index++]);
    }

}
