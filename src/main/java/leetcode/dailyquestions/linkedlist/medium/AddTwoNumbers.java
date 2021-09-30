package leetcode.dailyquestions.linkedlist.medium;

import leetcode.dailyquestions.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 * and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2);
        List<Integer> resultList = new ArrayList<>();
        while (result != null) {
            resultList.add(result.val);
            result = result.next;
        }
        System.out.println(resultList);

        assert "[8, 9, 9, 9, 0, 0, 0, 1]".equals(resultList.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node = null;
        ListNode head = null;
        int result = 0;
        int carry = 0;
        while(l1 != null && l2 != null) {
            result = l1.val + l2.val + carry;

            carry = 0;

            if (result > 9) {
                carry = result / 10;
                result = result % 10;
            }

            ListNode temp = new ListNode(result);

            if (node == null) {
                node = temp;
                head = node;
            } else {
                node.next = temp;
                node = node.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            result = l1.val + carry;

            carry = 0;

            if (result > 9) {
                carry = result / 10;
                result = result % 10;
            }

            ListNode temp = new ListNode(result);

            node.next = temp;
            node = node.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            result = l2.val + carry;

            carry = 0;

            if (result > 9) {
                carry = result / 10;
                result = result % 10;
            }

            ListNode temp = new ListNode(result);

            node.next = temp;
            node = node.next;

            l2 = l2.next;
        }

        if (carry > 0) {
            ListNode temp = new ListNode(carry);

            node.next = temp;
            node = node.next;
        }

        return head;

    }
}
