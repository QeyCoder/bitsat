package leetCode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Gaurav on 30/04/18.
 */


public class _729 {
    static class MyCalendarThree {


        private int min;
        private int max;

        TreeMap<Integer, Integer> nodes = new TreeMap<>();

        public static void main(String[] args) {

            MyCalendarThree ref = new MyCalendarThree();
            System.out.println(ref.book(10, 20));
            System.out.println(ref.book(15, 25));
            System.out.println(ref.book(20, 30));

        }



        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> entry = nodes.lowerEntry(end);

            if (entry != null && start < entry.getValue()) {
                return false;
            }

            nodes.put(start, end);
            return true;



        }
    }
}
