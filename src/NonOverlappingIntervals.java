
//https://leetcode.com/problems/non-overlapping-intervals/description/

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                answer++;
            } else {
                end = intervals[i][1];
            }
        }

        return answer;
    }


}
