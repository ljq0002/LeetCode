/*
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to
	 * their start times.
	 * 
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	 * in as [1,2],[3,10],[12,16].
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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
		int placestart = Collections.binarySearch(intervals, newInterval, comp);
		placestart = placestart < 0 ? -placestart - 1 : placestart;
		intervals.add(placestart, newInterval);
		return merge(intervals);
	}

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
			if (res.get(res.size() - 1).end >= intervals.get(i).start) {
				res.get(res.size() - 1).end = Math.max(intervals.get(i).end, res.get(res.size() - 1).end);
			} else {
				Interval temp = new Interval(intervals.get(i).start, intervals.get(i).end);
				res.add(temp);
			}
		}
		return res;
	}

}
