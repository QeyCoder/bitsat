package roundone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution78 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        while (cases-- > 0) {
            int size = scanner.nextInt();

            int[] power = new int[size];

            for (int i = 0; i < size; i++) {
                power[i] = scanner.nextInt();
            }
            Solution solution
                     = new Solution();
            List<List<Integer>> ans = solution.subsets(power);

            System.out.println(ans);
        }
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            int size = 1 << nums.length;
            for (int i = 0; i < size; i++) {
                lists.add(new ArrayList<>());

            }



            for (int i = 0; i < size; i++) {


                for (int j = 0; j < nums.length; j++) {
                    if ((i & (1 << j)) > 0) {
                        lists.get(i).add(nums[j]);

                    }

                }

            }

            return lists;


        }
    }
}
