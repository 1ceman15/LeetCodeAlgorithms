//https://leetcode.com/problems/maximize-distance-to-closest-person/description/


public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {

        int maxGap = 0;
        int start = -1;

        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 0)
                continue;
            if(start == -1)
                maxGap = Math.max(maxGap, i);
            else
                maxGap = Math.max(maxGap, (i-start)/2);

            start = i;
        }

        return Math.max(maxGap, seats.length - start -1);
    }
}
