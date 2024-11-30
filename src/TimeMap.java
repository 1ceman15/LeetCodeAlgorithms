
//https://leetcode.com/problems/time-based-key-value-store/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
       List<Pair> val =  map.computeIfAbsent(key, k-> new ArrayList<Pair>());
       val.add(new Pair(timestamp, value));
       map.put(key, val);

    }

    public String get(String key, int timestamp) {
        List<Pair> values =  map.getOrDefault(key, new ArrayList<>());

        int left = 0;
        int right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = (right + left) / 2;
            if (values.get(mid).getTime() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return result;
    }


    private class Pair{
        private int time;
        private String value;

        Pair(int time, String value){
            this.time = time;
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public String getValue() {
            return value;
        }
    }
}