/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
 * */
package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!q.isEmpty() && q.peekFirst() == i - k) {
				q.pollFirst();
			}
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			q.addLast(i);
			if (i >= k - 1) {
				res.add(nums[q.peekFirst()]);
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;
	}

}
