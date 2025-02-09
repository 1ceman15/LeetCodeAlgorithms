
//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int[] count = new int[26];
        int result = 0;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            count[s.charAt(right) - 'a']++;
            while (count[s.charAt(right) - 'a'] != 1) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == 3) {
                result++;
                count[s.charAt(left++) - 'a']--;
            }

            right++;

        }


        return result;
    }
}
