import java.util.ArrayList;
import java.util.List;

class Trie {

    char letter;
    List<Trie> children;
    boolean isWord = false;
    public Trie() {
        this.children = new ArrayList<>();
    }
    public Trie(char c) {
        letter = c;
        this.children = new ArrayList<>();
    }

    public void insert(String word) {
        if(word.length() == 0) {
            this.isWord = true;
            return;
        }
        Trie trie = findByChar(word.charAt(0));
        if(trie == null){
            trie = new Trie(word.charAt(0));
            children.add(trie);
        }
        trie.insert(word.substring(1));
    }

    public boolean search(String word) {
        Trie current = this;
        for (int i = 0; i < word.length(); i++) {
            current = current.findByChar(word.charAt(i));
            if(current == null)
                return false;
        }
        return current.isWord;
    }


    public boolean startsWith(String prefix) {
        Trie current = this;
        for (int i = 0; i < prefix.length(); i++) {
            current = current.findByChar(prefix.charAt(i));
            if(current == null)
                return false;
        }
        return true;
    }
    private Trie findByChar(char c){
        for(Trie trie: children){
            if(trie.letter == c)
                return trie;
        }

        return null;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */