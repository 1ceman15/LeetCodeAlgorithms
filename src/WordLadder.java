import java.util.*;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(!wordList.contains(endWord))
                return 0;

        HashMap<String, List<String>> nei = new HashMap<>();

        for(String word: wordList){
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String parent = q.poll();
                if(parent.equals(endWord))
                    return res;
                for (int j = 0; j < parent.length(); j++) {
                    String pattern = parent.substring(0,j) + "*" + parent.substring(j+1);
                    for (String word: nei.getOrDefault(pattern, Collections.emptyList())){
                        if(!visited.contains(word)){
                            visited.add(word);
                            q.add(word);
                        }
                    }
                }

            }
            res++;
        }

        return 0;

    }
}
