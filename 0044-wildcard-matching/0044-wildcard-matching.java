class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];

        prev[0] = true;

        // Initialize first row
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*')
                prev[j] = prev[j - 1];
        }

        for (int i = 1; i <= m; i++) {
            curr[0] = false;

            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    curr[j] = curr[j - 1] || prev[j];
                } else if (pc == '?' || pc == s.charAt(i - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = false;
                }
            }

            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}