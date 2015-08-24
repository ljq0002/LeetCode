/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 * */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		int prenum = nums[0] - 1;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == prenum) {
				continue;
			}
			if (nums[i] > 0) {
				break;
			} else {
				prenum = nums[i];
			}
			int pre = i + 1;
			int next = nums.length - 1;
			int target = -nums[i];
			while (pre < next) {
				if (pre > i + 1 && nums[pre] == nums[pre - 1]) {
					pre++;
					continue;
				}
				if (next < nums.length - 2 && nums[next] == nums[next + 1]) {
					next--;
					continue;
				}
				if (nums[pre] + nums[next] == target) {
					List<Integer> subres = new ArrayList<Integer>();
					subres.add(nums[i]);
					subres.add(nums[pre]);
					subres.add(nums[next]);
					res.add(subres);
					pre++;
					next--;
				} else if (nums[pre] + nums[next] > target) {
					next--;
				} else {
					pre++;
				}
			}
		}

		return res;
	}

}
