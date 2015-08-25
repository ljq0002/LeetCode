/*
		 * There are N children standing in a line. Each child is assigned a
		 * rating value.
		 * 
		 * You are giving candies to these children subjected to the following
		 * requirements:
		 * 
		 * Each child must have at least one candy. Children with a higher
		 * rating get more candies than their neighbors. What is the minimum
		 * candies you must give?
		 */

package leetcode;

public class Candy {
	public int candy(int[] ratings) {
		if (ratings.length == 0 || ratings.length == 1) {
			return ratings.length;
		}
		int[] res = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			if (i > 0 && ratings[i] > ratings[i - 1]) {
				res[i] = res[i - 1] + 1;
			} else {
				res[i] = 1;
			}
		}
		int sum = 0;
		for (int i = ratings.length - 1; i >= 0; i--) {
			if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
				res[i] = Math.max(res[i], res[i + 1] + 1);
			}
			sum += res[i];
		}

		return sum;
	}
}
