
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=problem-list-v2&envId=string


import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }else {
                answer = Math.max(answer, set.size());
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(i));
            }
        }

        return answer;

    }


}
