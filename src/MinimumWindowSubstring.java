
//https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";

        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();

        int[] result = new int[2];
        int resLen = Integer.MAX_VALUE;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen){
                    result[0] = l;
                    result[1] = r;
                    resLen = r - l  +1;
                }

                char ch = s.charAt(l);
                window.put(ch, window.get(ch) -1);

                if(countT.containsKey(ch) && window.get(ch) < countT.get(ch)){
                    have--;
                }

                l++;
            }

        }


        return resLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);

    }
}

