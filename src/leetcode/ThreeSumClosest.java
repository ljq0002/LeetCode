/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int subres = twoSumClosest(i + 1, nums, target - nums[i]);
			int newres = subres + nums[i];
			if (newres > target) {
				if (newres - target < dist) {
					res = newres;
					dist = newres - target;
				}
			} else if (newres < target) {
				if (target - newres < dist) {
					res = newres;
					dist = target - newres;
				}
			} else {
				return target;
			}

		}
		return res;
	}

	public int twoSumClosest(int from, int[] nums, int target) {
		int dist = Integer.MAX_VALUE;
		int res = 0;
		int head = nums.length - 1;
		int tail = from;
		while (tail < head) {
			if (nums[head] + nums[tail] > target) {
				if (nums[head] + nums[tail] - target < dist) {
					dist = nums[head] + nums[tail] - target;
					res = nums[head] + nums[tail];
				}
				head--;
			} else if (nums[head] + nums[tail] < target) {
				if (target - nums[head] - nums[tail] < dist) {
					dist = target - nums[head] - nums[tail];
					res = nums[head] + nums[tail];
				}
				tail++;
			} else
				return target;
		}
		return res;
	}

}
