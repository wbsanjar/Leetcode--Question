
class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find middle node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the linked list
        prev.next = null;

        // Middle node becomes root
        TreeNode root = new TreeNode(slow.val);

        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
