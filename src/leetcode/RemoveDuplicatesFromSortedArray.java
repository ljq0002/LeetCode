/*
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 */
package leetcode;

public class RemoveDuplicatesFromSortedArray {
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int count = 0;
		int cur = nums[0];
		for (int i = 1; i < nums.length - count; i++) {
			if (nums[i] == cur) {

				for (int j = i; j < nums.length - count - 1; j++) {
					nums[j] = nums[j + 1];
				}
				count++;
				i--;
			} else {
				cur = nums[i];
			}
		}
		return nums.length - count;
	}
}
