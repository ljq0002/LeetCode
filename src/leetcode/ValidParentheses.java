/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */
package leetcode;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> inputs = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char getc = s.charAt(i);
			switch (getc) {
			case '(':
				inputs.push(getc);
				break;
			case ')':
				if (inputs.empty()) {
					return false;
				}
				if (inputs.peek() != '(') {
					return false;
				} else {
					inputs.pop();
				}
				break;
			case '[':
				inputs.push(getc);
				break;
			case ']':
				if (inputs.empty()) {
					return false;
				}
				if (inputs.peek() != '[') {
					return false;
				} else {
					inputs.pop();
				}
				break;
			case '{':
				inputs.push(getc);
				break;
			case '}':
				if (inputs.empty()) {
					return false;
				}
				if (inputs.peek() != '{') {
					return false;
				} else {
					inputs.pop();
				}
				break;
			}
		}
		if (inputs.empty()) {
			return true;
		} else {
			return false;
		}
	}
}
