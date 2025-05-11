
//https://leetcode.com/problems/first-unique-character-in-a-string/description/


import java.util.HashMap;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer>   charFreq = new HashMap<>();
        for(char c: s.toCharArray()){
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(charFreq.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}
