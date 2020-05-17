package roundzero.day47;

import roundzero.template.FastInputReader;

import java.util.Stack;

/**
 * Created by Gaurav on 11/02/18.
 */
public class SaveGotham {

    public static void main(String[] args) {


        FastInputReader scanner
                = new FastInputReader(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        int cases = scanner.readInt();
        for (int i = 0; i < cases; i++) {
            int size = scanner.readInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scanner.readInt();
            }
            stringBuilder.append(solution(arr)).append("\n");
        }
        System.out.println(stringBuilder.toString());


    }

    private static long solution(int[] arr) {

        Stack<Integer> primary = new Stack<>();
        Stack<Integer> secondary = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            primary.push(arr[i]);
        }
        long sum = 0;
        while (!primary.empty()) {
            Integer poped = primary.pop();


            while (!primary.empty() && poped > primary.peek()) {
                secondary.push(primary.pop());
            }
            if (!primary.empty()) {
                sum += primary.peek() % (1e9 + 1);
            }
            while (!secondary.empty()) {
                primary.push(secondary.pop());
            }
        }
        return sum;
    }
}
