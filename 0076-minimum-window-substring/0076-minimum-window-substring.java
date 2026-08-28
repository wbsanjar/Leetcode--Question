class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        // Frequency of characters required from t
        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            // If this character is still needed
            if (need[c] > 0) {
                required--;
            }

            need[c]--;
            right++;

            // Window contains all characters of t
            while (required == 0) {

                // Update minimum window
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);

                need[leftChar]++;

                // Removing this character makes window invalid
                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}