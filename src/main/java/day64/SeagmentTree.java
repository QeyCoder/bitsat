package day64;

/**
 * Created by Gaurav on 07/04/18.
 */


public class SeagmentTree {


    public static void main(String[] args) {
        SeagmentTree st = new SeagmentTree();

        int input[] = {0, 3, 4, 2, 1, 6, -1};
        int segTree[] = st.createSegmentTree(input);

        //non lazy propagation example
        st.rangeMinimumQuery(segTree, 0, 3, input.length);
        st.rangeMinimumQuery(segTree, 1, 5, input.length);
        st.rangeMinimumQuery(segTree, 1, 6, input.length);
        st.updateSegmentTree(input, segTree, 2, 1);
        st.rangeMinimumQuery(segTree, 1, 3, input.length);
        st.updateSegmentTreeRange(input, segTree, 3, 5, -2);
        st.rangeMinimumQuery(segTree, 5, 6, input.length);
        st.rangeMinimumQuery(segTree, 0, 3, input.length);

        //lazy propagation example
        int input1[] = {-1, 2, 4, 1, 7, 1, 3, 2};
        int segTree1[] = st.createSegmentTree(input1);
        int lazy1[] = new int[segTree.length];
        st.updateSegmentTreeRangeLazy(input1, segTree1, lazy1, 0, 3, 1);
        st.updateSegmentTreeRangeLazy(input1, segTree1, lazy1, 0, 0, 2);
        st.rangeMinimumQueryLazy(segTree1, lazy1, 3, 5, input1.length);
    }


    int getSeagmentTreeSize(int n) {

        int p = 1;
        if (n > 0 && (n & (n - 1)) == 0)
            return 2 * n - 1;

        while (p < n)
            p <<= 1;
        return 2 * p - 1;

    }

    private int rangeMinimumQueryLazy(int[] input, int[] lazy1, int i, int i1, int length) {


        return 0;
    }

    private void updateSegmentTreeRange(int[] input, int[] segTree, int i, int i1, int i2) {

    }

    private void updateSegmentTreeRangeLazy(int[] input1, int[] segTree1, int[] lazy1, int i, int i1, int i2) {

    }

    private void updateSegmentTree(int[] input, int[] segTree, int i, int i1) {

    }

    private int[] createSegmentTree(int[] input) {
        int[] seagment = new int[getSeagmentTreeSize(input.length)];
        return new int[0];
    }

    private int rangeMinimumQuery(int[] segTree, int i, int i1, int length) {
        return 0;
    }


}
