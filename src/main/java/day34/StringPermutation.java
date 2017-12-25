package day34;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gaurav on 04/12/17.
 */
public class StringPermutation {

    public static void main(String[] args) {


        Scanner scanner
                = new Scanner(System.in);
        System.out.println("enter string to permute lexo order");
        solution(scanner.nextLine());
    }

    private static void solution(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer index = hashMap.get(ch);
            if (index == null) {
                hashMap.put(ch, 1);
            } else {
                hashMap.put(ch, index++);
            }
        }
        char[] result = new char[s.length()];
        char[] data = new char[hashMap.size()];
        int[] count = new int[hashMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> characterIntegerEntry : hashMap.entrySet()) {
            data[index] = characterIntegerEntry.getKey();
            count[index] = characterIntegerEntry.getValue();
            index++;
        }
        solve(data, count, result, 0);
    }

    private static void solve(char[] data, int[] count, char[] result, int level) {


        if (level == result.length) {
            print(result);
            return;
        }


        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = data[i];
            count[i]--;
            solve(data, count, result, level + 1);
            count[i]++;
        }

    }

    private static void print(char[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}
