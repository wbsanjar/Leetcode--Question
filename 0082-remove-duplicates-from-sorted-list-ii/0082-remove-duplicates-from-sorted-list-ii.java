class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        // Dummy node helps when duplicates occur at the beginning
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            
            // Check if current value is duplicated
            if (curr.next != null && curr.val == curr.next.val) {
                
                // Skip all nodes having the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                
                // Remove the complete duplicate group
                prev.next = curr.next;
                
            } else {
                // Current node is unique
                prev = prev.next;
            }
            
            curr = curr.next;
        }

        return dummy.next;
    }
}