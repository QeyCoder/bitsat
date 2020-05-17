package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Gaurav on 29/04/18.
 */


public class _435 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {

        _435 _435 = new _435();
        Interval[] ip = new Interval[4];
        ip[0] = new Interval(1, 100);
        ip[1] = new Interval(11, 22);
        ip[2] = new Interval(1, 11);
        ip[3] = new Interval(2, 12);
        System.out.println(_435.eraseOverlapIntervals(ip));

    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        int max = intervals[0].end;
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            Interval intvl = intervals[i];
            if (intvl.start
                    < max) {
                count++;
            } else {
                max = intvl.end;
            }

        }
        return count;

    }
}
