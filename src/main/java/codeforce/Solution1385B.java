package codeforce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution1385B {


    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        int n = Integer.parseInt(fs.nextLine());
        while (n-- > 0) {
            int length = Integer.parseInt(fs.nextLine());
            String[] arr = fs.nextLine().split(" ");
            solve( arr);
        }
    }

    private static void solve( String[] arr) {


        Set<Integer> integerIntegerMap
                = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int no = Integer.parseInt(arr[i]);
            if (!integerIntegerMap.contains(no)) {
                stringBuilder.append(no).append(" ");
                integerIntegerMap.add(no);
            }
        }
        System.out.println(stringBuilder.toString().trim());
    }


}



