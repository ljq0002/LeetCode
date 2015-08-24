/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * */
package leetcode;

public class SearchInRotatedSortedArray {
	public static boolean search(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		if (nums.length == 1 && nums[0] == target) {
			return true;
		}
		if (nums.length == 1 && nums[0] != target) {
			return false;
		}
		int l = 0;
		int r = nums.length - 1;
		int top = nums.length / 2;
		if (nums[l] == nums[r]) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] >= max) {
					if (i == nums.length - 1) {
						top = i;
						break;
					}
					if (nums[i] > nums[i + 1]) {
						max = nums[i];
						top = i;
						break;
					}
				}
			}
		} else {
			while (r - l != 1) {
				if (nums[top] >= nums[l]) {
					l = top;
					top = (r - top) / 2 + top;
				} else {
					r = top;
					top = (top - l) / 2 + l;
				}
			}
			top = nums[l] > nums[r] ? l : r;
		}

		if (target >= nums[0]) {
			l = 0;
			r = top;
		} else {
			if (top == nums.length - 1) {
				return false;
			}
			l = top + 1;
			r = nums.length - 1;
		}
		if (l == r && nums[l] == target) {
			return true;
		}
		if (l == r && nums[l] != target) {
			return false;
		}
		int index = (r - l) / 2 + l;
		while (r - l != 1) {
			if (nums[index] == target) {
				return true;
			}
			if (target < nums[index]) {
				r = index;
				index = (index - l) / 2 + l;
			} else {
				l = index;
				index = (r - index) / 2 + index;
			}
		}
		if (nums[l] == target) {
			return true;
		}
		if (nums[r] == target) {
			return true;
		}
		if (nums[index] == target) {
			return true;
		}
		return false;
	}

}
