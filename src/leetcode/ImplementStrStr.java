/*
	 * Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 */
package leetcode;

public class ImplementStrStr {

	public int strStr(String haystack, String needle) {
		if (haystack.length() == 0 && needle.length() == 0) {
			return 0;
		}
		if (haystack.length() != 0 && needle.length() == 0) {
			return 0;
		}
		if (haystack.length() == 0 && needle.length() != 0) {
			return -1;
		}
		for (int i = 0; i < haystack.length(); i++) {
			boolean issame = true;
			for (int j = 0; j < needle.length(); j++) {
				if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
					issame = false;
					break;
				}

			}
			if (issame) {
				return i;
			}

		}
		return -1;
	}
}
