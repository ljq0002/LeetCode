/*
    Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
    */
package leetcode;

import java.util.ArrayList;

public class StringtoInteger {

	public static int myAtoi(String str) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		boolean positive = true;
		boolean pmflag = false;
		if (str.length() == 0) {
			return 0;
		}
		while (str.charAt(0) == ' ') {
			str = str.substring(1);
		}
		for (int i = 0; i < str.length(); i++) {
			char getc = str.charAt(i);
			if (getc == '+') {
				if (pmflag == true) {
					return 0;
				}
				positive = true;
				pmflag = true;
			} else if (getc == '-') {
				if (pmflag == true) {
					return 0;
				}
				positive = false;
				pmflag = true;
			} else if (getc >= '0' && getc <= '9') {
				s.add(Integer.valueOf(getc - 48));
			} else {
				break;
			}
		}
		if (s.size() > 10) {
			if (positive) {
				return Integer.MAX_VALUE;
			} else {
				return Integer.MIN_VALUE;
			}
		}
		int result = 0;
		for (int i : s) {
			result *= 10;
			result += i;
		}
		if (!positive) {
			result = 0 - result;
		}
		if (positive && result < 0) {
			return Integer.MAX_VALUE;
		}
		if (!positive && result > 0) {
			return Integer.MIN_VALUE;
		}
		return result;
	}
}
