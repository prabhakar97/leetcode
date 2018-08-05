class Solution2 {
    class Solution {
        /**
         * 2. Add Two Numbers https://leetcode.com/problems/add-two-numbers/description/
         *
         * @param l1
         * @param l2
         * @return
         * @timeComplexity O(n)
         * @spaceComplexity O(1)
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            addHelper(head, 0, l1, l2);
            return head.next;
        }

        private void addHelper(ListNode cur, int carry, ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null && carry > 0) {
                ListNode newNode = new ListNode(carry);
                cur.next = newNode;
            } else if (l1 == null) {
                if (carry == 0) {
                    cur.next = l2;
                } else {
                    addHelper(cur, 0, new ListNode(carry), l2);
                }
            } else if (l2 == null) {
                if (carry == 0) {
                    cur.next = l1;
                } else {
                    addHelper(cur, 0, l1, new ListNode(carry));
                }
            } else {
                ListNode newNode = new ListNode((l1.val + l2.val + carry) % 10);
                cur.next = newNode;
                addHelper(newNode, (l1.val + l2.val + carry) / 10, l1.next, l2.next);
            }
        }
    }
}
