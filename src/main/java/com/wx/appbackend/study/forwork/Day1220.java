package com.wx.appbackend.study.forwork;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/12/20
 */
public class Day1220 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers1(l1, l2);
        System.out.println(result);
    }
}

class Solution {
    /**
     * 递归计算两个链表的和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        addNode(l1, l2, result, 0);
        return result;
    }

    /**
     * 迭代计算两个链表的和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null;
        if (l1 == null && l2 == null){
            return new ListNode(0);
        }
        ListNode cur = null;
        boolean flag = true;
        int carry = 0;
        while (flag){
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)+carry;
            if (head == null){
                head = new ListNode(val % 10);
                cur = head;
            }else {
                cur.next = new ListNode(val % 10);
                cur = cur.next;
            }
            carry = val / 10;
            if ((l1 == null || l1.next == null) && (l2==null || l2.next == null) && carry == 0){
                flag = false;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

    public void addNode(ListNode l1, ListNode l2, ListNode result, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }
        int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        result.val = val % 10;
        if ((l1 ==null || l1.next == null) && (l2==null || l2.next == null) && val/10 == 0){
            return;
        }
        result.next = new ListNode(0);
        addNode(l1 == null ? null : l1.next, l2 == null ? null : l2.next, result.next, val / 10);

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}