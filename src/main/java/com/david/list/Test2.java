package com.david.list;

/**
 */
public class Test2 {

    /**
     * 合并两个链表-递归
     */
    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.getValue() > head2.getValue()) {
            head = head2;
            head.setNext(mergeTwoList(head1, head2.getNext()));
        } else {
            head = head1;
            head.setNext(mergeTwoList(head1.getNext(), head2));
        }
        return head;
    }

    /**
     * 合并两个集合-非递归
     */
    public static ListNode mergeTwoList2(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (head1.getValue() < head2.getValue()) {
            head = head1;
            cur1 = head1;
            cur2 = head2;
        }
        if (head1.getValue() > head2.getValue()) {
            head = head2;
            cur2 = head1;
            cur1 = head2;
        }

        ListNode pre = null;//cur1前一个元素
        ListNode next = null;//cur2后一个元素
        while (cur1 != null && cur2 != null) {
            if (cur1.getValue() <= cur2.getValue()) {
                pre = cur1;
                cur1 = cur1.getNext();
            } else {
                next = cur2.getNext();
                pre.setNext(cur2);
                cur2.setNext(cur1);
                pre = cur2;
                cur2 = next;
            }
        }
        if (cur1 == null) {
            pre.setNext(cur2);
        } else {
            pre.setNext(cur1);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.setNext(node3);
        node2.setNext(node4);
        ListNode listNode = mergeTwoList2(node1, node2);
        while (listNode != null) {
            System.out.print(listNode.getValue() + " ");
            listNode = listNode.getNext();
        }
    }
}
