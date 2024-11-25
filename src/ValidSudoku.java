
//https://leetcode.com/problems/valid-sudoku/description/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer,HashSet<Character>> columns = new HashMap<>();
        Map<String, HashSet<Character>> squares = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;

                String key = (i/3) + "," + (j/3);
                if (rows.putIfAbsent(i, new HashSet<>()).contains(board[i][j]) ||
                        columns.putIfAbsent(j, new HashSet<>()).contains(board[i][j]) ||
                        squares.putIfAbsent(key, new HashSet<>()).contains(board[i][j])) {
                    return false;
                }


                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                squares.get(key).add(board[i][j]);
            }



        }










        return true;
    }
}
