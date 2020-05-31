package roundone;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution5425 {

    static class Solution {
        public int maxArea(int h, int w, int[] hc, int[] vc) {


            Arrays.sort(hc);
            Arrays.sort(vc);
            long maxh = hc[0];
            for (int i = 1; i < hc.length; i++) {
                maxh = Math.max(maxh, hc[i] - hc[i - 1]);
            }
            maxh = Math.max(maxh, h - hc[hc.length - 1]);

            long maxv = vc[0];
            for (int i = 1; i < vc.length; i++) {
                maxv = Math.max(maxv, vc[i] - vc[i - 1]);
            }
            maxv = Math.max(maxv, w - vc[vc.length - 1]);
            return (int)(maxh * maxv % 1000000007);
        }

        private int[] getdata(String s) {
            InputStream data = this.getClass().getClassLoader().getResourceAsStream(s);
            Scanner scanner
                    = new Scanner(data);
            List<String> numbers = new ArrayList<>();
            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextLine());
            }
            String[] strnArray = numbers.get(0).split(",");
            int[] arr = new int[strnArray.length];
            int i = 0;
            for (String strng : strnArray) {
                arr[i++] = Integer.parseInt(strng);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.maxArea(1000000000, 1000000000, solution.getdata("ip1.txt"), solution.getdata("ip2.txt"));
        System.out.println(ans);
    }


}
