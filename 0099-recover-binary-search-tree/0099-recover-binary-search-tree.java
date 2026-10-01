class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {

            // No left subtree
            if (curr.left == null) {
                check(curr);

                prev = curr;
                curr = curr.right;
            }

            // Has left subtree
            else {
                TreeNode predecessor = curr.left;

                // Find rightmost node in left subtree
                while (predecessor.right != null &&
                       predecessor.right != curr) {
                    predecessor = predecessor.right;
                }

                // Create temporary link
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                }

                // Remove temporary link
                else {
                    predecessor.right = null;

                    check(curr);

                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        // Swap the two incorrect values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void check(TreeNode curr) {
        if (prev != null && prev.val > curr.val) {

            if (first == null) {
                first = prev;
            }

            second = curr;
        }
    }
}