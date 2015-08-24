/*Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 * */
package leetcode;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		if (divisor == -1 && dividend == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (divisor == 1) {
			return dividend;
		}
		boolean isNeg = (dividend ^ divisor) >>> 31 == 1;
		int res = 0;
		if (dividend == Integer.MIN_VALUE) {
			res++;
			dividend += Math.abs(divisor);
		}
		if (divisor == Integer.MIN_VALUE) {
			return res;
		}

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int dig = 0;
		while (dividend >> 1 >= divisor) {
			divisor <<= 1;
			dig++;
		}
		while (dig >= 0) {
			if (dividend - divisor >= 0) {
				dividend -= divisor;
				res += 1 << dig;
			}
			dig--;
			divisor >>= 1;
		}
		return isNeg ? -res : res;
	}
}
