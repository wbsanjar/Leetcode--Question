class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        // First row: there is only one way to reach each cell.
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // Process remaining rows.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}