package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1399C {


    static class Pair {
        int x;
        int y;

        public Pair(int i, int j) {
            this.x =i;
            this.y =j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (x == pair.y || y == pair.x || x == pair.x || y == pair.y) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        while (n-- > 0) {
            int size = fs.nextInt();
            int[] arr = fs.readArray(size);
            Map<Integer, Set<Pair>> integerListMap = new HashMap<>();
            int max =0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int sum = arr[i] + arr[j];
                    Set<Pair> pairs =  new HashSet<>();
                    if(integerListMap.containsKey(sum)){
                        pairs = integerListMap.get(sum);
                    }
                    pairs.add(new Pair(i,j));
                    integerListMap.put(sum, pairs);
                    if(pairs.size()>max){
                        max =  pairs.size();
                    }
                }
            }
            System.out.println(max);
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }
}



