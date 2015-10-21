/*
Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval in1, Interval in2){
               return in1.start - in2.start;
           } 
        });
        List<Interval> result = new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(cur.start <= pre.end){
                pre = new Interval(pre.start, Math.max(pre.end, cur.end));
            }else{
                result.add(pre);
                pre = cur;
            }
        }
        result.add(pre);
        return result;
    }
}