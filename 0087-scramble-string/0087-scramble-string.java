class Solution {

    // Memoization: key = s1 + "#" + s2
    private HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        // Same string
        if (s1.equals(s2)) {
            return true;
        }

        // Different character frequencies -> impossible
        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                return false;
            }
        }

        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Try every possible split
        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            // s1 = left + right
            // s2 = left + right
            boolean noSwap =
                    isScramble(
                        s1.substring(0, i),
                        s2.substring(0, i)
                    )
                    &&
                    isScramble(
                        s1.substring(i),
                        s2.substring(i)
                    );

            // Case 2: Swap
            // s1 = left + right
            // s2 = right + left
            boolean swap =
                    isScramble(
                        s1.substring(0, i),
                        s2.substring(n - i)
                    )
                    &&
                    isScramble(
                        s1.substring(i),
                        s2.substring(0, n - i)
                    );

            if (noSwap || swap) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}