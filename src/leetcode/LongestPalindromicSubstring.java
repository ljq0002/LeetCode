/*Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * */
package leetcode;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}

		int max = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			int p = i;
			int pace = 0;
			while (p - pace >= 0 && p + pace < s.length()) {
				if (s.charAt(p - pace) == s.charAt(p + pace)) {
					if (pace * 2 + 1 > max) {
						max = pace * 2 + 1;
						result = s.substring(p - pace, p + pace + 1);
					}
					pace++;
				} else {
					break;
				}
			}
			p = i;
			int q = i + 1;
			pace = 0;
			while (p - pace >= 0 && q + pace < s.length()) {
				if (s.charAt(p - pace) == s.charAt(q + pace)) {
					if (pace * 2 + 2 > max) {
						max = pace * 2 + 2;
						result = s.substring(p - pace, q + pace + 1);
					}
					pace++;
				} else {
					break;
				}
			}
		}
		return result;
	}
}
