import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @timeComplexity O(n)
 * @spaceComplexity O(1)
 */
public class L23 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        class QueueNode {
            Integer val;
            int comingFrom;
            QueueNode(int val, int comingFrom) {
                this.val = val;
                this.comingFrom = comingFrom;
            }
        }
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<QueueNode> heap = new PriorityQueue<>(new Comparator<QueueNode>() {
                @Override
                public int compare(QueueNode o1, QueueNode o2) {
                    return o1.val.compareTo(o2.val);
                }
            });
            // Process first item from each list and populate the queue
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    heap.add(new QueueNode(lists[i].val, i));
                }
            }
            if (heap.isEmpty()) {
                return null;
            }

            ListNode head = new ListNode(0);
            ListNode cur = head;
            ListNode prev = cur;
            while (!heap.isEmpty()) {
                QueueNode item = heap.poll();
                cur.val = item.val;
                cur.next = new ListNode(0);
                prev = cur;
                cur = cur.next;
                lists[item.comingFrom] = lists[item.comingFrom].next;
                if (lists[item.comingFrom] != null)
                    heap.add(new QueueNode(lists[item.comingFrom].val, item.comingFrom));
            }
            prev.next = null;
            return head;
        }
    }
}
