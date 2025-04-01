import java.util.ArrayList;

public class RecentCounter {

    private ArrayList<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int counter = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) < t - 3000) {
                break;
            }
            counter++;
        }

        return counter;
    }


//    private static final int[] records = new int[10000]; //
//    private int start;
//    private int end;
//
//    public RecentCounter() {
//        start = 0;
//        end = 0;
//    }
//
//    public int ping(int t) {
//        while (start < end && (t - records[start] > 3000)) {
//            start++; // if the difference in time is greater than 3000ms,
//            // than increase the value of start unitl it's equal or less than 3000ms.
//        }
//        records[end++] = t; // Inserting the current time at the end
//        return end - start; // Returning the answer including the element added just now.
//    }

}
