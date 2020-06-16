package roundone;

import java.util.*;

//https://codeforces.com/problemset/problem/758/A
public class HolidayEquality {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(solve(scanner.nextLine()));
    }

    private static int solve(String s) {
        String[] op = s.split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            integerList.add(Integer.parseInt(op[i]));
        }
        int max = integerList.stream().max(Comparator.comparingInt(o -> o)).get();
        return integerList.stream().mapToInt(integer -> max - integer).sum();

    }
}
