/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> re = new ArrayList<String>();
		if (n == 0) {
			return re;
		}
		re.add("()");
		if (n == 1) {
			return re;
		}
		List<List<String>> cola = new ArrayList<List<String>>();
		List<List<String>> colb = new ArrayList<List<String>>();
		for (int i = 0; i < n - 1; i++) {
			cola.add(generateParenthesis(i + 1));
			colb.add(generateParenthesis(n - i - 1));
		}
		List<String> subre = generateParenthesis(n - 1);
		re = new ArrayList<String>();
		for (int i = 0; i < subre.size(); i++) {
			String c = "(" + subre.get(i) + ")";
			if (!re.contains(c)) {
				re.add(c);
			}
		}
		for (int i = 0; i < cola.size(); i++) {
			for (int p = 0; p < cola.get(i).size(); p++) {
				for (int q = 0; q < colb.get(i).size(); q++) {
					String c = cola.get(i).get(p) + colb.get(i).get(q);
					if (!re.contains(c)) {
						re.add(c);
					}
				}
			}
		}
		return re;
	}
}
