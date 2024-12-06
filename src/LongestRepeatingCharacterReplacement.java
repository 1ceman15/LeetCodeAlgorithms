
//https://leetcode.com/problems/longest-repeating-character-replacement/description/


public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {

        int result = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);

        }
        return result;


    }
}