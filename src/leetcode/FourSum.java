/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		HashMap<Integer, List<int[]>> twosum = new HashMap<Integer, List<int[]>>();
		for (int i = 0; i < nums.length - 1; i++) {

			for (int j = i + 1; j < nums.length; j++) {

				int[] twonum = { i, j };
				if (twosum.containsKey(nums[i] + nums[j])) {
					twosum.get(nums[i] + nums[j]).add(twonum);
				} else {
					List<int[]> newlist = new ArrayList<int[]>();
					newlist.add(twonum);
					twosum.put(nums[i] + nums[j], newlist);
				}
			}
		}

		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				if (twosum.containsKey(target - nums[i] - nums[j])) {
					List<int[]> targetlist = (List<int[]>) twosum.get(target - nums[i] - nums[j]);
					int temp1 = nums[0] - 1;
					int temp2 = nums[0] - 1;
					for (int[] ints : targetlist) {
						if (ints[0] > j) {
							if (nums[ints[0]] == temp1 || nums[ints[1]] == temp2) {
								continue;
							}
							List<Integer> subres = new ArrayList<Integer>();
							subres.add(nums[i]);
							subres.add(nums[j]);
							subres.add(nums[ints[0]]);
							subres.add(nums[ints[1]]);
							res.add(subres);
							temp1 = nums[ints[0]];
							temp2 = nums[ints[1]];
						}
					}
				}
			}
		}
		return res;

	}
}
