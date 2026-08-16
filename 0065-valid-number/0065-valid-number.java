class Solution {
    public boolean isNumber(String s) {
        int n = s.length();
        int i = 0;

        // Optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        // Digits before decimal point
        boolean hasDigits = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            hasDigits = true;
            i++;
        }

        // Optional decimal part
        if (i < n && s.charAt(i) == '.') {
            i++;

            // Digits after decimal point
            while (i < n && Character.isDigit(s.charAt(i))) {
                hasDigits = true;
                i++;
            }
        }

        // Must have at least one digit overall
        if (!hasDigits) {
            return false;
        }

        // Optional exponent
        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;

            // Exponent can have an optional sign
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }

            // Exponent must contain at least one digit
            boolean exponentDigits = false;
            while (i < n && Character.isDigit(s.charAt(i))) {
                exponentDigits = true;
                i++;
            }

            if (!exponentDigits) {
                return false;
            }
        }

        // Everything must have been consumed
        return i == n;
    }
}