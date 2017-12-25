package day33;/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.util.Scanner;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//https://www.hackerearth.com/challenge/hiring/practo-developer-hiring-challenge/problems/27c58a56a7f34488a6645b5b506952b0/
class Reunion {
    public static void main(String args[]) throws Exception {
        Scanner inputReader
                = new Scanner(System.in);
        String[] d = inputReader.nextLine().split(" ");
        int n = Integer.parseInt(d[0]);
        int k = Integer.parseInt(d[1]);
        String[] data = inputReader.nextLine().split("");
        int arr[] = new int[n];

        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }


        for (int i = 0; i < k; i++) {
            String input = inputReader.nextLine();
            if (input.length() == 1) {
                solution(arr);
            } else {
                String[] splitted = input.split(" ");
                int X = Integer.parseInt(splitted[1]);
                arr[X-1] = 1;
                //solution(arr);
            }
        }
    }

    private static void solution(int[] arr) {

        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            else if (arr[i] == 0) {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }

        }
        if (count > max) {
            max = count;
        }
        System.out.println(max);

    }


}
