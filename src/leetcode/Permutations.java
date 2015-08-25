/*
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 1) {
			List<Integer> li = new ArrayList<Integer>();
			li.add(nums[0]);
			List<List<Integer>> lli = new ArrayList<List<Integer>>();
			lli.add(li);
			return lli;
		} else {
			List<List<Integer>> lli = new ArrayList<List<Integer>>();
			for (int i = 0; i < nums.length; i++) {
				int head = nums[i];
				int[] sub = new int[nums.length - 1];
				for (int j = 0; j < sub.length; j++) {
					if (j < i) {
						sub[j] = nums[j];
					} else {
						sub[j] = nums[j + 1];
					}
				}
				List<List<Integer>> sublist = permute(sub);
				for (List<Integer> e : sublist) {
					e.add(0, head);
				}
				lli.addAll(sublist);
			}
			return lli;
		}
	}
}
