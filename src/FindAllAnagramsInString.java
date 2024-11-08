
//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length())
            return result;

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
            freqS[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freqP, freqS)) {
            result.add(0);
        }

        for (int i = 1; i <= s.length() - p.length(); i++) {
            freqS[s.charAt(i - 1) - 'a']--;
            freqS[s.charAt(i + p.length() - 1) - 'a']++;
            if(Arrays.equals(freqP, freqS)) {
                result.add(i);
            }

        }

        return result;

    }

}
