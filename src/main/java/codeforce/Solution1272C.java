package codeforce;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1272C {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        solve1(scanner.nextLine(), scanner.nextLine());
    }

    private static void solve(String s, String s1) {

        List<String> data = Arrays.stream(s1.split(" ")).collect(Collectors.toList());
        long[] store = new long[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (data.contains(String.valueOf(s.charAt(i)))) {
                store[i] = 1;
            }
        }

        for (int i = 1; i < store.length; i++) {
            if (store[i] == 1) {
                store[i] = store[i - 1] + 1;
            }
        }
        long ans = 0;
        boolean reset = true;
        for (int i = store.length - 1; i >= 0; i--) {
            if (reset) {
                ans += store[i] * (store[i] + 1) / 2;
                reset = false;
            }
            if (store[i] == 0) {
                reset = true;
            }


        }
        System.out.println(ans);
    }
    private static void solve1(String s, String s1) {

        List<String> data = Arrays.stream(s1.split(" ")).collect(Collectors.toList());
        List<Integer> store = new ArrayList<>();
        store.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (!data.contains(String.valueOf(s.charAt(i)))) {
                store.add(i);
            }
        }
        store.add(s.length());

        long ans = 0;
        for (int i = 1; i < store.size(); i++) {
            long size = store.get(i) - store.get(i - 1)-1;
            if(size>0)
                ans+=(size*(size+1))/2;
        }
        System.out.println(ans);
    }
}
