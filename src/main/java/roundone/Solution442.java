package roundone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution442 {


    public static void main(String[] args) {
        new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    static class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int m = Math.abs(nums[i])-1;
                int elmnt = nums[m];
                if(nums[elmnt]<0){
                    ans.add(Math.abs(nums[m+1]));
                }
                nums[m]=-nums[m];

            }

            return ans;

        }
    }
}



