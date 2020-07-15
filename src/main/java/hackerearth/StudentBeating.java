package hackerearth;

import java.util.*;
import java.util.stream.Collectors;

public class StudentBeating {


    public static void main(String[] args) {
        Scanner fs = new Scanner(System.in);
        int n = Integer.parseInt(fs.nextLine());
        while (n-- > 0) {
            int size = Integer.parseInt(fs.nextLine());
            List<Integer> boys = get(fs.nextLine());
            List<Integer> girls = get(fs.nextLine());
            solve(boys, girls);
        }
    }

    private static List<Integer> get(String s) {
        return Arrays.stream(s.split(" ")).map(s1 -> Integer.parseInt(s1)).collect(Collectors.toList());
    }

    private static void solve(List<Integer> boys, List<Integer> girls) {

        Map<Integer, Integer> integerList = new HashMap<>();
        for (int i = 0; i < boys.size(); i++) {
            int boyIndex = girls.get(boys.get(i) - 1) - 1;
            if (i != boyIndex) {
                integerList.put(i, boyIndex);
            }
        }
        Map<Integer, Integer> glt = new HashMap<>();
        for (int i = 0; i < girls.size(); i++) {
            int grlIndex = boys.get(girls.get(i) - 1) - 1;
            if (i != grlIndex) {
                glt.put(i, grlIndex);
            }
        }

        HashMap<Integer, Integer> IntegerHashMap = new HashMap<>();

        for (Integer integer : integerList.values()) {
            IntegerHashMap.put(integer, IntegerHashMap.getOrDefault(integer, 0) + 1);
        }

        Integer max = IntegerHashMap.values().stream().max(Integer::compareTo).get();
        IntegerHashMap = new HashMap<>();
        for (Integer integer : glt.values()) {
            IntegerHashMap.put(integer, IntegerHashMap.getOrDefault(integer, 0) + 1);
        }
        Integer tmp = IntegerHashMap.values().stream().max(Integer::compareTo).get();
        if (tmp > max) {
            max = tmp;
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> integer : integerList.entrySet()) {
            Integer key = integer.getKey();
            Integer val = integer.getValue();
            if (integerList.containsKey(val) && integerList.get(val).equals(key)) {
                ans++;
            }
        }
        for (Map.Entry<Integer, Integer> integer : glt.entrySet()) {
            Integer key = integer.getKey();
            Integer val = integer.getValue();
            if (glt.containsKey(val) && glt.get(val).equals(key)) {
                ans++;
            }
        }

        System.out.println(max + " " + ans / 2);
    }

}



