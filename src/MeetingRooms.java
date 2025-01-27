import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(interval -> interval.end));

        for (int i = 0; i < intervals.size() -1; i++) {
            int end = intervals.get(i).end;
            int start = intervals.get(i + 1).start;
            if (end > start)
                return false;
        }


        return true;



    }

}
