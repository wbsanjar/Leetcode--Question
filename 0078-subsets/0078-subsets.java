import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Add the current subset
        result.add(new ArrayList<>(current));

        // Try adding each remaining element
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            // Backtrack: remove the last element
            current.remove(current.size() - 1);
        }
    }
}