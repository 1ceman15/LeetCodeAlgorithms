
//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    public void solve(char[][] board) {

        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O')
                dfs(board, 0, c);
            if (board[board.length - 1][c] == 'O')
                dfs(board, board.length - 1, c);
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O')
                dfs(board, r, 0);
            if (board[r][board[0].length - 1] == 'O')
                dfs(board, r, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }


    }

    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
            return;

        board[r][c] = 'T';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
