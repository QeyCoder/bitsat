package roundzero.day33;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//https://www.hackerearth.com/challenge/hiring/zscaler-developer-hiring-challenge/problems/29aff17fb0624f6cadd4c9c5877d9d47/
class RoundTableMeeting {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        HashMap<String, List<Integer>> set = new HashMap<>();

        String[] pos = br.readLine().split(" ");
        for (int i = 0; i < pos.length; i++) {
            String data = pos[i];
            List<Integer> present = set.get(data);
            if (present == null) {
                present = new ArrayList<>();
            }
            present.add(i);

            set.put(data, present);
        }
        for (int i = 0; i < k; i++) {
            String meeting[] = br.readLine().split(" ");

            String one = meeting[0];
            String two = meeting[1];

            List<Integer> onesPos = set.get(one);
            List<Integer> twoPost = set.get(two);
            Collections.sort(onesPos);
            Collections.sort(twoPost);

            Integer a = onesPos.get(0);
            Integer b = twoPost.get(0);
            Integer c = onesPos.get(onesPos.size() - 1);
            Integer d = twoPost.get(twoPost.size() - 1);
            a = a > onesPos.size() / 2 ? n  - a : a;
            b = b > onesPos.size() / 2 ? n  - b : b;
            c = c > onesPos.size() / 2 ?n - c : c;
            d = d > onesPos.size() / 2 ? n  - d : d;


            System.out.println(Math.min(Math.abs(a - b) / 2, Math.abs(c - d) / 2));
        }


    }


}
