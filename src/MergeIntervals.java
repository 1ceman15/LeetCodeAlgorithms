
//https://leetcode.com/problems/merge-intervals/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
     public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

         List<int[]> res = new ArrayList<>();

         int[] prev = intervals[0];

        for(int[] interval : intervals) {
            if(prev[1] >=  interval[0]) {
                prev[1] = Math.max(interval[1], prev[1]);
            }else {
                res.add(prev);
                prev = interval;
            }

        }
        res.add(prev);

         return  res.toArray(new int[res.size()][]);
     }

}
