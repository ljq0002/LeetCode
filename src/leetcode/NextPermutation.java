/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
package leetcode;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums.length < 2) {
			return;
		}
		int index1 = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				index1 = i - 1;
				break;
			}
		}
		if (index1 == -1) {
			Arrays.sort(nums);
			return;
		}
		int index2 = -1;
		for (int i = nums.length - 1; i > index1; i--) {
			if (nums[i] > nums[index1]) {
				index2 = i;
				break;
			}
		}
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
		index1++;
		index2 = nums.length - 1;
		while (index1 < index2) {
			temp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = temp;
			index1++;
			index2--;
		}
	}
}
