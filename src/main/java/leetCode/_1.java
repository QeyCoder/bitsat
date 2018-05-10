package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class _1 {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hash = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			hash.put(nums[i],i);
		}

		for (int i = 0; i < nums.length; i++) {
			 int diff = target- nums[i];
			if(hash.get(diff)!=null && i!= hash.get(diff)){
				return new int[]{i, hash.get(target-nums[i])};	
			}
		}
		  return new int[]{};
	}

	public static void main(String[] args) {
		_1 ref = new _1();
		ref.twoSum(new int[] { 3, 2, 4 }, 6);
		System.out.println("ss");
	}
}
