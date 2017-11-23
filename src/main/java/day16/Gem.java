package day16;

import java.util.Scanner;

class Gem {

    static int gemstones(String[] arr) {

        int[] chars = new int[26];
        for (int i = 0; i < arr.length; i++) {

            String ip = arr[i];
            for (int j = 0; j < ip.length(); j++) {

                int alpha = ip.charAt(j) - 97;
                if(chars[alpha] == i){
                    chars[alpha]++;
                }

            }
        }


        int count = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] ==arr.length) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}
