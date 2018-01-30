package seagmentTree;

import template.InputReader;

/**
 * Created by Gaurav on 30/01/18.
 */
public class SeagmentTreeMaxRangeQuery {


    public static void main(String[] args) {

        InputReader inputReader = new InputReader(System.in);
        int n = inputReader.readInt();
        int q = inputReader.readInt();

        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = inputReader.readInt();
        }
        SeagmentTree seagmentTree = new SeagmentTree(data, n);
        seagmentTree.build(0, 0, n - 1);


        for (int i = 0; i < q; i++) {
            int sR = inputReader.readInt();
            int eR = inputReader.readInt();
            int value = inputReader.readInt();
            seagmentTree.update(0, 0, n - 1, sR-1, eR-1, value);
            System.out.println(seagmentTree.query(0, 0, n - 1, 0, n - 1));
        }


    }
}
