/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * */
package leetcode;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		int index = 0;
		while (index < nums.length) {
			if (nums[index] > 0 && nums[index] != index + 1 && nums[index] <= nums.length
					&& nums[nums[index] - 1] != nums[index]) {
				int temp = nums[index];
				nums[index] = nums[nums[index] - 1];
				nums[temp - 1] = temp;
			} else {
				index++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
}
