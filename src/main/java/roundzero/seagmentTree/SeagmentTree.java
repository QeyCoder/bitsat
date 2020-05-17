package roundzero.seagmentTree;

/**
 * Created by Gaurav on 30/01/18.
 */
public class SeagmentTree {

    private final int[] tree;
    private final int[] data;

    public SeagmentTree(int[] data, int n) {
        this.data = data;
        int height = (int) Math.ceil(Math.log(n) / Math.log(2));
        int size = (1 << height + 1) - 1;
        int segmentTree[] = new int[size];
        this.tree = new int[segmentTree.length];

    }

    /*
                left child = i*2+1
                right child =  i*2 + 2
        */
    void build(int startIndex, int start, int end) {
        if (start > end) {
            // outside range
            return;
        }
        if (start == end) {
            //we are at leaf node
            tree[startIndex] = data[start];
            return;
        }


        int mid = (start + end) / 2;

        build(startIndex * 2 + 1, start, mid);
        build(startIndex * 2 + 2, mid + 1, end);

        //storing the max value as we are building tree with max values in a given seagment

        tree[startIndex] = max(tree[startIndex * 2 + 1], tree[startIndex * 2 + 2]);


    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    int query(int indexS, int start, int end, int searchStart, int searchEnd) {

        if (start > end || start > searchEnd || end < searchStart) {
            //outside range
            return Integer.MAX_VALUE;
        }
        if (searchStart >= start && searchEnd <= end) {
            return tree[indexS];
        }
        int mid = (start + end) / 2;

        int result1 = query(indexS, start, mid, searchStart, searchEnd);
        int result2 = query(indexS, mid + 1, end, searchStart, end);
        return max(result1, result2);

    }

    /**
     * increament value with in range
     */
    void update(int nodeIndex, int start, int end, int updateStart, int updateEnd, int valueToBeAdd) {
        if (start > end || start > updateEnd || end < updateStart) {
            //outside range
            return;
        }

        if (start == end) {
            tree[nodeIndex] += valueToBeAdd;
            return;
        }
        int mid = (start + end) / 2;

        update(nodeIndex * 2 + 1, start, mid, updateStart, end, valueToBeAdd);
        update(nodeIndex * 2 + 2, mid + 1, end, updateStart, end, valueToBeAdd);

        tree[nodeIndex] = max(tree[nodeIndex * 2 + 1], tree[nodeIndex * 2 + 2]);

    }
}
