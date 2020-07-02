package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeForce443A {


    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);
        String n = scanner.nextLine();
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(n.split("")).forEach(x -> {

            if (!x.equals("{") && !x.equals("}") && !x.equals(",") && !x.equals(" ")) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        });
        System.out.println(map.size());
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



