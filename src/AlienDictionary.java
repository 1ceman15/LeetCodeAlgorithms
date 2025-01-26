import java.util.*;

//https://neetcode.io/problems/foreign-dictionary
public class AlienDictionary {
    public String foreignDictionary(String[] words) {
        HashMap<Character, HashSet<Character>> nei = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for(String word: words){
            for(char c: word.toCharArray()){
                nei.putIfAbsent(c, new HashSet<>());
                inDegree.put(c,0);
            }
        }


        for (int i = 0; i < words.length -1 ; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(),w2.length());
            if(w1.substring(0,minLen).equals(w2.substring(0,minLen)) && w2.length() < w1.length())
                return "";
            for (int j = 0; j < minLen; j++) {
                if(w1.charAt(j) != w2.charAt(j)){
                    if(!nei.get(w1.charAt(j)).contains(w2.charAt(j))){
                        inDegree.put(w2.charAt(j), inDegree.get(w2.charAt(j))+1);
                        nei.get(w1.charAt(j)).add(w2.charAt(j));
                    }
                    break;
                }

            }
        }

        Queue<Character> q = new LinkedList();

        StringBuilder result = new StringBuilder();

        for (char c: inDegree.keySet()){
            if(inDegree.get(c) == 0)
                q.add(c);
        }

        while (!q.isEmpty()){
            char c = q.poll();
            result.append(c);
            for (char ch: nei.get(c)){
                inDegree.put(ch, inDegree.get(ch)-1);
                if(inDegree.get(ch) == 0)
                    q.add(ch);
            }
        }

        if(result.length() == inDegree.size())
            return result.toString();

        return "";
    }


}
