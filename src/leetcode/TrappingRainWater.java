/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


 * */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
	public static int trap(int[] height) {
		if (height.length < 2) {
			return 0;
		}
		List<Integer> place = new ArrayList<Integer>();
		List<Integer> heights = new ArrayList<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (i == 0) {
				if (height[i] > height[i + 1]) {
					place.add(i);
					heights.add(height[i]);
				}
				continue;
			}
			if (i == height.length - 1) {
				if (height[i] > height[i - 1]) {
					place.add(i);
					heights.add(height[i]);
				}
				continue;
			}
			if (height[i] >= height[i + 1] && height[i] >= height[i - 1]) {
				place.add(i);
				heights.add(height[i]);
			}
		}
		int p1 = 0;
		int p2 = place.size() - 1;
		while (p1 != p2) {
			if (heights.get(p1) == 0) {
				p1++;
				continue;
			}
			if (heights.get(p2) == 0) {
				p2--;
				continue;
			}
			int h = Math.min(heights.get(p1), heights.get(p2));
			for (int i = p1; i < p2; i++) {

				if (heights.get(i) < h)
					heights.set(i, 0);
			}
			if (heights.get(p1) < heights.get(p2)) {
				p1++;
			} else {
				p2--;
			}
		}
		while (heights.contains(0)) {
			int place0 = heights.indexOf(0);
			place.remove(place0);
			heights.remove(place0);
		}
		if (place.size() < 2) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < place.size() - 1; i++) {
			int heightmin = Math.min(heights.get(i), heights.get(i + 1));
			int place1 = place.get(i);
			int place2 = place.get(i + 1);
			for (int j = place1; j < place2; j++) {
				sum += heightmin - height[j] > 0 ? heightmin - height[j] : 0;
			}
		}
		return sum;
	}
}
