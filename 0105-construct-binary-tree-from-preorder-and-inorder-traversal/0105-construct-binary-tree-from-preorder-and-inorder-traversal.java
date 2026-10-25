class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preIndex,
                           int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);

        int i = inStart;
        while (inorder[i] != preorder[preIndex]) {
            i++;
        }

        int leftSize = i - inStart;

        root.left = build(preorder, inorder, preIndex + 1,
                          inStart, i - 1);

        root.right = build(preorder, inorder, preIndex + leftSize + 1,
                           i + 1, inEnd);

        return root;
    }
}