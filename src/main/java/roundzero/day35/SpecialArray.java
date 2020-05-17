package day35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//https://www.hackerearth.com/challenge/hiring/sapient-global-markets-java-hiring-challenge-1/problems/3957c19f129a4359adf282cc5d26d715/
class SpecialArray {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());                // Reading input from STDIN

        int[] arr = new int[size];


        String[] data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }


        solution(arr);


        // Write your roundzero.code here

    }

    private static void solution(int[] arr) {

        //instead of adding element and sorting we can use priority queue to solve this in logn 
        List<Integer> prime = new ArrayList<>();
        List<Integer> nonPrime = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            int no = arr[i];
            if (isPrime(no)) {

                prime.add(no);
            } else {
                nonPrime.add(no);
            }
        }


        Collections.sort(prime, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Collections.sort(nonPrime, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        prime.addAll(nonPrime);
        for (Integer integer : prime) {
            System.out.print(integer + " ");
        }
    }

    static private boolean isPrime(int A) {
        if (A == 1 || A == 0) {
            return false;
        }
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0)
                return false;
        }
        return true;
    }

}
