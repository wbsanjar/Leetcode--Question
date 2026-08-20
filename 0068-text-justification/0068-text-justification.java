import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineWordsLength = 0;

            // Find the words that fit in this line
            while (j < words.length) {
                int newLength = lineWordsLength + words[j].length();

                // At least one space between every pair of words
                int spaces = j - i;

                if (newLength + spaces > maxWidth) {
                    break;
                }

                lineWordsLength = newLength;
                j++;
            }

            int numberOfWords = j - i;
            int totalSpaces = maxWidth - lineWordsLength;

            StringBuilder line = new StringBuilder();

            // Last line OR line with only one word -> left justified
            if (j == words.length || numberOfWords == 1) {
                for (int k = i; k < j; k++) {
                    if (k > i) {
                        line.append(' ');
                    }
                    line.append(words[k]);
                }

                // Pad remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } else {
                // Fully justified line
                int gaps = numberOfWords - 1;

                // Extra spaces are distributed from left to right
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spaces = spacesPerGap;

                        // Left gaps get one extra space
                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(' ');
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}