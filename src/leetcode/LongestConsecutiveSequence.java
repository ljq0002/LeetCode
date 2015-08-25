/*
	 * 
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 * 
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 * 
	 * Your algorithm should run in O(n) complexity.
	 */

package leetcode;

import java.util.Arrays;

public class LongestConsecutiveSequence {
		public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		Arrays.sort(nums);
		int max = 1;
		int count = 1;
		int cur = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == cur) {
				continue;
			}
			if (nums[i] - cur == 1) {
				count++;
				max = Math.max(count, max);
				cur = nums[i];
			} else {
				cur = nums[i];
				count = 1;
			}
		}
		return max;
	}

}
