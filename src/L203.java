public class L203 {
    class Solution {
        /**
         * 203. Remove Linked List Elements https://leetcode.com/problems/remove-linked-list-elements
         *
         * @param head
         *          Head of the list
         * @param val
         *          Value to be removed
         * @return Head of the new list
         * @timeComplexity O(n)
         * @spaceComplexity O(1)
         */

        public ListNode removeElements(ListNode head, int val) {
            // Remove all the val nodes from the beginning
            while (head != null && head.val == val) {
                head = head.next;
            }
            // Check if we are at the end of list already
            if (head == null) {
                return head;
            }
            ListNode ptr = head;
            ListNode prev = null;
            while (ptr != null) {
                if (ptr.val == val) {
                    prev.next = ptr.next;
                } else {
                    prev = ptr;
                }
                ptr = ptr.next;
            }
            return head;
        }
    }
}
