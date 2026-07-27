class Solution {

    int count = 0;

    public int totalNQueens(int n) {

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        solve(0, n, col, diag1, diag2);

        return count;
    }

    private void solve(int row, int n, boolean[] col,
                       boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {

            int d1 = row - c + n - 1;
            int d2 = row + c;

            if (col[c] || diag1[d1] || diag2[d2])
                continue;

            col[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            solve(row + 1, n, col, diag1, diag2);

            col[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}