import java.util.*;

//https://leetcode.com/problems/merge-intervals/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervalsI) {
        List<Interval> intervals = new ArrayList<Interval>(intervalsI);
        Collections.sort(intervals, new IntervalComparator());
        
        for(int i = 0; i < intervals.size() - 1; i++) {

            if(isOverlap(intervals.get(i), intervals.get(i+1))) {
                Interval merged = merge(intervals.get(i), intervals.get(i + 1));
                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i, merged);
                i = i - 1;
            }
        }
        
        return intervals;
    }
    
    public class IntervalComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval)o1;
            Interval i2 = (Interval)o2;
            if(i1.start!=i2.start)
                return i1.start-i2.start;
            else
                return i1.end-i2.end;
        }
    }
    private Interval merge(Interval first, Interval second) {
        int max= first.end > second.end ? first.end : second.end;
        return new Interval(first.start, max);
    }
    
    private boolean isOverlap(Interval first, Interval second) {
        if(second.start >= first.start && second.end <= first.end) return true;
        if(second.start >=first.start && second.start <= first.end && second.end >= first.end) return true;
        
        return false;
    }
}
