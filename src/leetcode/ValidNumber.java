/*
	 * Validate if a given string is numeric.
	 * 
	 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
	 * "2e10" => true Note: It is intended for the problem statement to be
	 * ambiguous. You should gather all requirements up front before
	 * implementing one.
	 * 
	 * 
	 */
package leetcode;

public class ValidNumber {
	
	public static boolean isNumber(String s) {
		int state = 1;
		if (s.length() == 0) {
			return false;
		}
		if (s.length() == 1 && s.charAt(0) == ' ') {
			return false;
		}
		while (s.charAt(0) == ' ') {
			s = s.substring(1);
		}
		while (s.charAt(s.length() - 1) == ' ') {
			s = s.substring(0, s.length() - 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char getc = s.charAt(i);
			switch (state) {
			case 1:
				if (getc == '+' || getc == '-') {
					state = 2;
				} else if (getc == '.') {
					state = 8;
				} else if (getc >= '0' && getc <= '9') {
					state = 3;
				} else {
					return false;
				}
				break;
			case 2:
				if (getc >= '0' && getc <= '9') {
					state = 3;
				} else if (getc == '.') {
					state = 8;
				} else {
					return false;
				}
				break;
			case 3:
				if (getc >= '0' && getc <= '9') {
					state = 3;
				} else if (getc == '.') {
					state = 4;
				} else if (getc == 'e') {
					state = 5;
				} else {
					return false;
				}
				break;
			case 4:
				if (getc >= '0' && getc <= '9') {
					state = 6;
				} else if (getc == 'e') {
					state = 5;
				} else {
					return false;
				}
				break;
			case 5:
				if (getc >= '0' && getc <= '9') {
					state = 7;
				} else if (getc == '+' || getc == '-') {
					state = 9;
				} else {
					return false;
				}
				break;
			case 6:
				if (getc >= '0' && getc <= '9') {
					state = 6;
				} else if (getc == 'e') {
					state = 5;
				} else {
					return false;
				}
				break;
			case 7:
				if (getc >= '0' && getc <= '9') {
					state = 7;
				} else {
					return false;
				}
				break;
			case 8:
				if (getc >= '0' && getc <= '9') {
					state = 6;
				} else {
					return false;
				}
				break;
			case 9:
				if (getc >= '0' && getc <= '9') {
					state = 7;
				} else {
					return false;
				}
				break;
			}
		}
		if (state == 3 || state == 4 || state == 6 || state == 7) {
			return true;
		} else {
			return false;
		}
	}

}
