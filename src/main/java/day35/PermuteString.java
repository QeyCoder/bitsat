package day35;

/**
 * Created by Gaurav on 21/12/17.
 */
//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
public class PermuteString {
    public static void main(String[] args) {

        String data = "gaurav";
        solution(data, 0, data.length() - 1);

    }

    private static void solution(String data, int s, int e) {

        if (s == e) {
            System.out.println(data);
            return;
        }
        for (int j = s; j <= e; j++) {
            swap(data, s, j);
            solution(data, s + 1, e);
            swap(data, s, j);
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

