/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
		Comparator<Interval> comp = new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) {
					return i1.end - i2.end;
				} else {
					return i1.start - i2.start;
				}
			}
		};
		Collections.sort(intervals, comp);

		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (res.get(res.size() - 1).end >= intervals.get(i).start)
				res.get(res.size() - 1).end = Math.max(intervals.get(i).end, res.get(res.size() - 1).end);
			else {
				Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
				res.add(temp);
			}
		}
		return res;
	}
}
