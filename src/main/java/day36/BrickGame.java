package day36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BrickGame {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(bufferedReader.readLine());
            String[] data = bufferedReader.readLine().split(" ");

            solution(data, 0);
        }

    }

    private static int solution(String[] data, int i) {

        Math.max(Math.max(Integer.parseInt(data[i]), Integer.parseInt(data[i]) + Integer.parseInt(data[i + 1])), Integer.parseInt(data[i]) + Integer.parseInt(data[i + 1]) + Integer.parseInt(data[i + 1]));
        return 0;
    }
}