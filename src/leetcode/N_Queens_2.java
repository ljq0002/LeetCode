package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_2 {
	public int totalNQueens(int n) {
		List<List<StringBuilder>> result = new ArrayList<List<StringBuilder>>();
		List<StringBuilder> cur = new ArrayList<StringBuilder>();
		char[] init = new char[n];
		for (char i : init) {
			i = '.';
		}
		for (int i = 0; i < n; i++) {
			StringBuilder s = new StringBuilder();
			for (int j = 0; j < n; j++) {
				s.append('.');
			}
			cur.add(s);
		}
		helper(result, cur, 0);
		List<List<String>> result2 = new ArrayList<List<String>>();
		for (int i = 0; i < result.size(); i++) {
			ArrayList<String> subr = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				subr.add(result.get(i).get(j).toString());
			}
			result2.add(subr);
		}
		return result2.size();
	}

	public static void helper(List<List<StringBuilder>> result, List<StringBuilder> cur, int row) {
		if (row == cur.size()) {
			List<StringBuilder> subres = new ArrayList<StringBuilder>();
			for (StringBuilder s : cur) {
				StringBuilder cp = new StringBuilder(s);
				subres.add(cp);
			}
			result.add(subres);
			return;
		}
		for (int i = 0; i < cur.size(); i++) {
			if (isValid(cur, row, i)) {
				cur.get(row).setCharAt(i, 'Q');
				helper(result, cur, row + 1);
				cur.get(row).setCharAt(i, '.');
			}
		}
	}

	public static boolean isValid(List<StringBuilder> cur, int row, int col) {
		boolean[] lu2rd = new boolean[2 * cur.size() - 1];
		boolean[] ru2ld = new boolean[2 * cur.size() - 1];
		boolean[] colcheck = new boolean[cur.size()];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cur.size(); j++) {
				char curchar = cur.get(i).charAt(j);
				if (curchar == 'Q') {
					ru2ld[i - j + cur.size() - 1] = true;
					lu2rd[cur.size() - 1 - i - j + cur.size() - 1] = true;
					colcheck[j] = true;
				}
			}
		}
		if (ru2ld[row - col + cur.size() - 1] || lu2rd[cur.size() - 1 - row - col + cur.size() - 1] || colcheck[col]) {
			return false;
		}
		return true;
	}
}
