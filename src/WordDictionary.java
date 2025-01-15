
//https://leetcode.com/problems/design-add-and-search-words-data-structure/

public class WordDictionary {
    TrieNode node;

    public WordDictionary() {
        this.node = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = this.node;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this.node);
    }

    private boolean dfs(String word, int j, TrieNode cur){
        TrieNode current = cur;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child: current.children){
                    if(child != null && dfs(word, i+1, child))
                        return true;
                }
                return false;
            }else{
                int index = c - 'a';
                if(current.children[index] == null)
                    return false;
                current = current.children[index];
            }
        }
        return current.isWord;
    }


    class TrieNode{
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}
