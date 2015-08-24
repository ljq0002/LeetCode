/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * */
package leetcode;

public class JumpGame_2 {
	public int jump(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int max = 0;
		int temp = 0;
		int res = 0;
		for (int i = 0; i < nums.length - 1;) {
			if (temp >= nums.length - 1) {
				break;
			}
			while (i <= temp) {
				max = Math.max(max, i + nums[i]);
				i++;
			}
			temp = max;
			res++;
		}
		return max >= nums.length - 1 ? res : 0;
	}

}
