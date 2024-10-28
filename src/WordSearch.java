//https://leetcode.com/problems/word-search/description/

import java.util.HashSet;
import java.util.List;

public class
WordSearch {
    public static boolean exist(char[][] board, String word) {
        HashSet<List<Integer>> set = new HashSet<>();

        int[] freq = new int[58];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                freq[(int) board[i][j] - 'A']++;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (--freq[word.charAt(i) - 'A'] <= 0)
                return false;
        }

        if (freq[word.charAt(0) - 'A'] > freq[word.charAt(word.length() - 1) - 'A'])
            word = new StringBuilder(word).reverse().toString();


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (DFS(board, word, 0, i, j))
                    return true;
            }
        }

        return false;
    }


    public static boolean DFS(char[][] board, String word, int index, int row, int col) {
        if (index == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length
                || word.charAt(index) != board[row][col] || board[row][col] == '*')
            return false;

        char temp = board[row][col];
        board[row][col] = '*';


        boolean res = DFS(board, word, index + 1, row + 1, col) ||
                DFS(board, word, index + 1, row - 1, col) ||
                DFS(board, word, index + 1, row, col + 1) ||
                DFS(board, word, index + 1, row, col - 1);

        board[row][col] = temp;


        return res;
    }


}
