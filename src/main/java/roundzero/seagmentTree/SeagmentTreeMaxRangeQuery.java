package roundzero.seagmentTree;

import roundzero.template.FastInputReader;

/**
 * Created by Gaurav on 30/01/18.
 */
public class SeagmentTreeMaxRangeQuery {


    public static void main(String[] args) {

        FastInputReader fastInputReader = new FastInputReader(System.in);
        int n = fastInputReader.readInt();
        int q = fastInputReader.readInt();

        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = fastInputReader.readInt();
        }
        SeagmentTree seagmentTree = new SeagmentTree(data, n);
        seagmentTree.build(0, 0, n - 1);


        for (int i = 0; i < q; i++) {
            int sR = fastInputReader.readInt();
            int eR = fastInputReader.readInt();
            int value = fastInputReader.readInt();
            seagmentTree.update(0, 0, n - 1, sR-1, eR-1, value);
            System.out.println(seagmentTree.query(0, 0, n - 1, 0, n - 1));
        }


    }
}
