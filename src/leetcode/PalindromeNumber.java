/*
 Determine whether an integer is a palindrome. Do this without extra space.
*/
package leetcode;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x < 10) {
			return true;
		}
		int keta = 0;
		int temp = x;
		while (temp > 0) {
			keta++;
			temp /= 10;
		}
		for (int i = 0; i < keta / 2; i++) {
			int pre = (x / (int) Math.pow(10, keta - i - 1)) % 10;
			int post = (x / (int) Math.pow(10, i)) % 10;
			if (pre != post) {
				return false;
			}
		}
		return true;
	}

}
