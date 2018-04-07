package flipkart;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gaurav on 01/04/18.
 */


public class Question1 {

    static int max = 100002;

    public static void main(String[] args) {

        int K = 7;
        int[] set = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubOArray(set, set.length, K));


    }

    static int setBits(int n) {
        int on = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                on++;
            }
            n = n / 2;
        }
        return on;
    }

    static int minSubOArray(int ip[], int n, int k) {


        int minL = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0;
        int j = 0;

        while (i <= j && j < n) {

            sum += ip[j];
            if (sum >= k) {
                if (sum == k) {
                    if (j - i + 1 < minL)
                        minL = j - i + 1;
                }
                sum -= ip[i++];
            } else {
                sum += ip[j++];
            }
        }
        return minL;

    }

    static int minSubArray(int ip[], int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int currentAtlestKLenght = 0;

        int min = max;
        q.add(ip[0]);
        currentAtlestKLenght = currentAtlestKLenght + ip[0];
        for (int i = 1; i < n; i++) {
            if (currentAtlestKLenght >= k && q.size() < min && !q.isEmpty()) {
                min = q.size();
            }
            q.add(ip[i]);
            currentAtlestKLenght = currentAtlestKLenght + ip[i];
            while (currentAtlestKLenght >= k && !q.isEmpty()) {
                if (currentAtlestKLenght >= k && q.size() < min && !q.isEmpty()) {
                    min = q.size();
                }
                int x = q.poll();
                currentAtlestKLenght = currentAtlestKLenght - x;
            }
        }
        while (currentAtlestKLenght >= k && !q.isEmpty()) {
            if (currentAtlestKLenght >= k && q.size() < min)
                min = q.size();
            int x = q.poll();
            currentAtlestKLenght = currentAtlestKLenght - x;
        }

        if (min == max)
            return -1;
        return min;
    }


}


