
//https://leetcode.com/problems/word-search-ii/description/

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {

        TrieNode node = addToPrefixTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board,i,j, node);
            }
        }



        return result;
    }

    public void backtracking(char[][] board, int row, int col, TrieNode node){
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0
                || board[row][col] == '*' || node.children[board[row][col] - 'a'] == null)
            return;

       char temp = board[row][col];
       board[row][col] = '*';
       TrieNode prev = node;
       node = node.children[temp - 'a'];
       if(node.word != null) {
           result.add(node.word);
           node.word = null;
       }

       backtracking(board, row + 1, col, node);
       backtracking(board, row - 1, col, node);
       backtracking(board, row, col+1, node);
       backtracking(board, row, col-1, node);
       board[row][col] = temp;
       node = prev;
    }




    private TrieNode addToPrefixTrie(String[] words){
        TrieNode trie = new TrieNode();

        for(int i = 0; i < words.length; i++)
            trie.insert(words[i]);

        return trie;
    }



    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;

        public void insert(String word){
            TrieNode node = this;
            for (char c: word.toCharArray()) {
                int i = c - 'a';
                if(node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.word = word;
        }

    }

}
