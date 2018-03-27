package seagmentTreeG4G;

import template.FastInputReader;

/**
 * Created by Gaurav on 11/03/18.
 */

//https://www.geeksforgeeks.org/segment-tree-xor-given-range/
public class XorTree {


    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        StringBuilder stringBuilder = new StringBuilder();

        int N = fastInputReader.readInt();
        int[] ip = fastInputReader.readIntArray(N);
        int Q = fastInputReader.readInt();

        constructSeagment(ip, N - 1);
        for (int i = 0; i < Q; i++) {


            int operation = fastInputReader.readInt();
            if (operation == 1) {
                //find xor

            } else if (operation == 2) {
                // update the index with value
            }
        }


    }

    private static void constructSeagment(int[] ip, int n) {
        int x = (int) (Math.ceil(Math.log(n)));

        // Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        int[] segment = new int[max_size];

        constructSeagmentUtil(ip, 0, n, segment, 0);


    }

    private static int constructSeagmentUtil(int[] ip, int ipIndex, int ipEndIndex, int[] segment, int seagmentIndex) {

        if (ipIndex == ipEndIndex) {
            segment[seagmentIndex] = ip[ipIndex];
            return segment[seagmentIndex];
        }
        int mid = ipIndex + (ipEndIndex - ipIndex) / 2;

        segment[seagmentIndex] =
                constructSeagmentUtil(ip, ipIndex, mid, segment, 2 * seagmentIndex + 1) ^ constructSeagmentUtil(ip, ipIndex, mid, segment, 2 * seagmentIndex + 2);
        return segment[seagmentIndex];

    }


}
