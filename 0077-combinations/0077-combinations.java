import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // If we selected k numbers, add the combination
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible number
        for (int i = start; i <= n; i++) {

            // Choose
            current.add(i);

            // Explore
            backtrack(i + 1, n, k, current, result);

            // Backtrack (remove the last choice)
            current.remove(current.size() - 1);
        }
    }
}