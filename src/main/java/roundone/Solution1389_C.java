package roundone;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//https://codeforces.com/contest/1368/problem/C
public class Solution1389_C {

static class pair{
    int x;int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
    public static void main(String args[]) {
        Scanner scanner
                = new Scanner(System.in);
        int ip = Integer.parseInt(scanner.nextLine());


        List<pair> pairs =  new ArrayList<>();
        for (int i = 0; i <=ip; i++) {
            pairs.add(new pair(i,i));
            pairs.add(new pair(i+1,i));
            pairs.add(new pair(i,i+1));
        }
        pairs.add(new pair(ip+1,ip+1));
        System.out.println(pairs.size());
        for (pair pair : pairs) {
            System.out.println(pair.x+" "+pair.y);
        }

    }
}
