/*
		 * Given a string S and a string T, count the number of distinct
		 * subsequences of T in S.
		 * 
		 * A subsequence of a string is a new string which is formed from the
		 * original string by deleting some (can be none) of the characters
		 * without disturbing the relative positions of the remaining
		 * characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is
		 * not).
		 * 
		 * Here is an example: S = "rabbbit", T = "rabbit"
		 * 
		 * Return 3.
		 */
package leetcode;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		if (t.length() > s.length() || t.length() == 0) {
			return 0;
		}
		int[][] table = new int[s.length() + 1][t.length() + 1];
		// t[i][j] = t[i][j - 1] + t[i - 1][j - 1]
		table[0][0] = 1;
		for (int i = 1; i < table.length; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i < table[0].length; i++) {
			table[0][i] = 0;
		}
		for (int i = 1; i < table.length; i++)
			for (int j = 1; j < table[0].length; j++) {
				if (s.charAt(i - 1) != t.charAt(j - 1)) {
					table[i][j] = table[i - 1][j];
				} else {
					table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
				}
			}
		return table[s.length()][t.length()];

	}
}
