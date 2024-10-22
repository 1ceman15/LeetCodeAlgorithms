
//https://leetcode.com/problems/insert-interval/description/


import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();


        int start = newInterval[0];
        int end = newInterval[1];

        int index = 0;

        while(index < intervals.length && intervals[index][1] < start) {
            res.add(intervals[index]);
            index++;
        }


        while(index < intervals.length && intervals[index][0] <= end) {
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }

        res.add(new int[]{start, end});

        for(int i = index; i < intervals.length; i++) {
            res.add(intervals[i]);
        }






        return res.toArray(new int[res.size()][]);

    }

}
