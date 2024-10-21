
//https://leetcode.com/problems/interval-list-intersections/description/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                result.add(new int[]{left, right});
            }
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            }else {
                j++;
            }


        }

        return result.toArray(new int[result.size()][]);
    }

}
