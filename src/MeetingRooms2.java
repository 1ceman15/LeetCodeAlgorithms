import java.util.Arrays;
import java.util.List;

public class MeetingRooms2 {
    public int minMeetingRooms(List<Interval> intervals) {
        int answer = 0;

        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int start = 0;
        int end = 0;
        int count = 0;
        while (start < intervals.size() && end < intervals.size()) {
            if (starts[start] < ends[end]) {
                count++;
                start++;
            } else {
                count--;
                end++;
            }
            answer = Math.max(answer, count);
        }

        
        return answer;

    }
}
