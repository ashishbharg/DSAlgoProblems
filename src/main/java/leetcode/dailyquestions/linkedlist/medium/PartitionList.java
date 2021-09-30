package leetcode.dailyquestions.linkedlist.medium;

import leetcode.dailyquestions.linkedlist.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5, new ListNode(2));
        ListNode result = partition(node, 3);
        assert result.val == 1;
        assert result.next.val == 2;
        assert result.next.next.val == 2;
        assert result.next.next.next.val == 4;
        assert result.next.next.next.next.val == 3;
        assert result.next.next.next.next.next.val == 5;
    }

    public static ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }
        ListNode start = null;
        ListNode temp = head;

        if (head.val < x) {
            start = head;
        }

        while (temp.next != null) {
            if (temp.next.val >= x) {
                temp = temp.next;
                continue;
            }
            if (start != null && start.next == temp.next) {
                start = start.next;
                temp = temp.next;
                continue;
            }
            ListNode node = new ListNode(temp.next.val);
            if (start == null) {
                node.next = head;
                head = node;
                start = node;
            } else {

                while(start.next != null && start.next.val < x) {
                    start = start.next;
                }
                node.next = start.next;
                start.next = node;
                start = start.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}
