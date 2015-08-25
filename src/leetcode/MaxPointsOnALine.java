//Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
package leetcode;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	public static int maxPoints(Point[] points) {
		int max = 0;
		if (points.length == 1) {
			return 1;
		}
		for (int i = 0; i < points.length; i++) {
			Point cur = points[i];
			HashMap<Double, Integer> hs = new HashMap<Double, Integer>();
			int countsame = 0;
			for (int j = 0; j < points.length; j++) {
				Point curcur = points[j];

				if (i != j) {

					if (curcur.x == cur.x && curcur.y == cur.y) {
						countsame++;
					} else {
						double k;
						if ((curcur.x - cur.x) == 0) {
							k = Double.POSITIVE_INFINITY;
						} else {
							k = (double) (curcur.y - cur.y) / (double) (curcur.x - cur.x);
						}
						if (!hs.containsKey(k)) {
							hs.put(k, 1);
						} else {
							hs.put(k, hs.remove(k) + 1);
						}
					}
				}
			}
			if (hs.size() == 0) {
				max = max < countsame + 1 ? countsame + 1 : max;
			}
			for (Map.Entry<Double, Integer> entry : hs.entrySet()) {
				if (max - countsame < entry.getValue() + 1) {
					max = entry.getValue() + countsame + 1;
				}
			}
		}
		return max;
	}
}
