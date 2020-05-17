package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/challenge/competitive/december-circuits-17/algorithm/left-or-right-92c0b54c/
class LeftOrRight {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ip = br.readLine().split(" ");
        int N = Integer.parseInt(ip[0]);
        int Q = Integer.parseInt(ip[1]);
        String[] arr1 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(arr1[i]);
        }
        for (int i = 0; i < Q; i++) {
            String query[] = br.readLine().split(" ");
            int src = Integer.parseInt(query[0]);
            int destination = Integer.parseInt(query[1]);
            String direction = query[2];
            System.out.println(solution(src, destination, direction, arr, 0));
        }


    }

    private static int solution(int src, int destination, String direction, int[] arr, int count) {
        int N = arr.length;
        if (count > N) {
            return -1;
        }
        if (direction.equals("R")) {
            solution((src - 1 + N) % N, destination, direction, arr, count++);
        } else {
            solution((src + 1) % N, destination, direction, arr, count++);
        }
        if (arr[src] == arr[destination]) {
            return count;
        }

        return src;
    }
}
