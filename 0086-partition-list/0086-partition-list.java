class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for two lists
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);

        // Pointers to build the lists
        ListNode beforePtr = before;
        ListNode afterPtr = after;

        while (head != null) {

            if (head.val < x) {
                beforePtr.next = head;
                beforePtr = beforePtr.next;
            } else {
                afterPtr.next = head;
                afterPtr = afterPtr.next;
            }

            head = head.next;
        }

        // Important: terminate the after list
        afterPtr.next = null;

        // Connect the two lists
        beforePtr.next = after.next;

        return before.next;
    }
}