/*
    Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
    */

package leetcode;

import java.util.ArrayList;

public class RomanToInteger {
	public int romanToInt(String s) {
		/* I（1）、V（5）、X（10）、L（50）、C（100）、D（500）和M（1000） */
		ArrayList<Integer> keta = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char getc = s.charAt(i);
			switch (getc) {
			case 'I':
				keta.add(1);
				break;
			case 'V':
				keta.add(5);
				break;
			case 'X':
				keta.add(10);
				break;
			case 'L':
				keta.add(50);
				break;
			case 'C':
				keta.add(100);
				break;
			case 'D':
				keta.add(500);
				break;
			case 'M':
				keta.add(1000);
				break;
			}
		}
		int sum = 0;
		for (int i = 0; i < keta.size(); i++) {
			if (i == 0) {
				sum += keta.get(i);
			} else {
				sum += keta.get(i);
				if (keta.get(i) > keta.get(i - 1)) {
					sum -= 2 * keta.get(i - 1);
				}
			}
		}
		return sum;

	}
}
