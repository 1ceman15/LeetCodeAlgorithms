
//https://leetcode.ca/2016-05-07-159-Longest-Substring-with-At-Most-Two-Distinct-Characters/

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();


        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (start < s.length() && map.keySet().size() > 2){
                char delete = s.charAt(start++);
                map.put(delete,map.getOrDefault(delete, 0) -1);
                if(map.get(delete) <= 0)
                    map.remove(delete);
            }

            max = Math.max(max, i - start + 1);

        }


        return max;
    }
}
