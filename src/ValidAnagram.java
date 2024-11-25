
//https://leetcode.com/problems/valid-anagram/description/

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) return false;

        int[] freqT = new int[26];
        int[] freqS = new int[26];

        for (int i = 0; i < t.length(); i++) {
            freqT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
        }


        return Arrays.equals(freqT, freqS);

    }

}
