package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//imports for BufferedReader
class BeautifulSequence {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(br.readLine());
            int arr[] = new int[size];
            String[] da = br.readLine().split(" ");
            for (int j = 0; j < da.length; j++) {
                arr[j] = Integer.parseInt(da[j]);
            }
            System.out.println(solution(arr));
        }
    }

    private static int solution(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1] || arr[i] == arr[i - 1]) {
                count++;
            }
        }
        return count;
    }
}