package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution716B {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
            int l = Integer.parseInt(scanner.nextLine().split(" ")[1]);
            String[] one = scanner.nextLine().split(" ");

            String[] two = scanner.nextLine().split(" ");
            List<Integer> firstStore = get(one, l);
            List<Integer> seconStore = get(two, l);

            if(firstStore.size()!=seconStore.size()){
                System.out.println("NO");
                return;
            }

            while (l-->0){

                if(firstStore.equals(seconStore)){
                    System.out.println("YES");
                    return;
                }
                Integer element = firstStore.remove(0);
                firstStore.add(element);
            }
            System.out.println("NO");

    }

    private static List<Integer> get(String[] one, int l) {
        List<Integer> tmp = new ArrayList<Integer>();

        for (int i = 1; i < one.length; i++) {
            tmp.add(Integer.parseInt(one[i]) - Integer.parseInt(one[i - 1]));
        }
        tmp.add(l- Integer.parseInt(one[one.length-1])+ Integer.parseInt(one[0]));
//        tmp.sort(Integer::compareTo);
        return tmp;
    }
}
