/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 * */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations_2 {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		List<Integer> cur = new ArrayList<Integer>();
		List<Integer> rem = new ArrayList<Integer>();
		HashSet<List<Integer>> hm = new HashSet<List<Integer>>();
		for (int i : nums) {
			rem.add(i);
		}
		permuteUnique(cur, rem, res, hm);
		return res;
	}

	public static void permuteUnique(List<Integer> cur, List<Integer> rem, List<List<Integer>> res,
			HashSet<List<Integer>> hm) {
		if (rem.isEmpty()) {
			if (hm.contains(cur)) {
				return;
			}
			List<Integer> curres = new ArrayList<Integer>();
			curres.addAll(cur);
			res.add(curres);
			hm.add(curres);
			return;
		}
		for (int i = 0; i < rem.size(); i++) {
			if (i > 0 && (rem.get(i) == rem.get(i - 1))) {
				continue;
			}
			int curint = rem.get(i);
			rem.remove(i);
			cur.add(curint);
			permuteUnique(cur, rem, res, hm);
			cur.remove(cur.size() - 1);
			rem.add(i, curint);
		}

	}
}
