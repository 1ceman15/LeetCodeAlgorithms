import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/n-queens/description/
public class NQueens {
    List<List<String>> result = new ArrayList<>();
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> posD = new HashSet<>();
    HashSet<Integer>  negD = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtracking(board,0,n);

        return result;
    }

    private void backtracking(char[][] board, int row, int n){
        if(row== n){
            List<String> copy = new ArrayList<>();
            for (char[] r : board) {
                copy.add(new String(r));
            }
            result.add(copy);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!cols.contains(i) && !posD.contains(i+row) && !negD.contains(row-i)){
                cols.add(i);
                posD.add(i+row);
                negD.add(row-i);
                board[row][i] = 'Q';

                backtracking(board, row+1, n);

                cols.remove(i);
                posD.remove(i+row);
                negD.remove(row-i);
                board[row][i] = '.';

            }


        }

    }
}
