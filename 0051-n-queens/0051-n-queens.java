class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        solve(0, n, board, col, diag1, diag2);

        return ans;
    }

    private void solve(int row, int n, char[][] board,
                       boolean[] col,
                       boolean[] diag1,
                       boolean[] diag2) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board)
                temp.add(new String(r));
            ans.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || diag1[row - c + n] || diag2[row + c])
                continue;

            board[row][c] = 'Q';
            col[c] = true;
            diag1[row - c + n] = true;
            diag2[row + c] = true;

            solve(row + 1, n, board, col, diag1, diag2);

            board[row][c] = '.';
            col[c] = false;
            diag1[row - c + n] = false;
            diag2[row + c] = false;
        }
    }
}