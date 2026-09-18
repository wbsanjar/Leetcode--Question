import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // 1. Visit left subtree
        inorder(root.left, result);

        // 2. Visit root
        result.add(root.val);

        // 3. Visit right subtree
        inorder(root.right, result);
    }
}