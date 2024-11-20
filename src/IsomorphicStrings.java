
//https://leetcode.com/problems/isomorphic-strings/


import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(mapS.containsKey(s.charAt(i)) && mapS.get(s.charAt(i)) != t.charAt(i)
             || mapT.containsKey(t.charAt(i)) && mapT.get(t.charAt(i)) != s.charAt(i))
                return false;
            mapS.put(s.charAt(i), t.charAt(i));
            mapT.put(t.charAt(i), s.charAt(i));

        }
        return true;
    }
}
