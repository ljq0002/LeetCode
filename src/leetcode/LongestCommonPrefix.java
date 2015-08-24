/*
    Write a function to find the longest common prefix string amongst an array of strings.*/
package leetcode;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int count = 0;
		for (int i = 0; i < strs[0].length(); i++) {
			if (issame(strs, i)) {
				count++;
			} else {
				break;
			}
		}
		return strs[0].substring(0, count);

	}

	public static boolean issame(String[] strs, int index) {
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < index + 1) {
				return false;
			}
		}
		char sub = strs[0].charAt(index);
		for (int i = 0; i < strs.length; i++) {
			char sub2 = strs[i].charAt(index);
			if (sub != sub2) {
				return false;
			}
		}
		return true;
	}
}
