package com.david.list;

/**
 */
public class Test1 {

    /**
     * 反转链表
     * o(n) o(1)
     * 假设是1 2 3 4
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;//当前节点的上一个
        ListNode next = null;//当前节点的下一个
        while (head != null) {
            //next=2
            next=head.getNext();
            //head.getNext()=null;
            head.setNext(pre);
            //pre=1
            pre=head;
            //head=2
            head=next;
        }
        return pre;
    }

    /**
     * 获取中间值
     */
    public static ListNode getMid(ListNode headNode){
        if (headNode == null) {
            return headNode;
        }
        ListNode fast=headNode;
        ListNode slow=headNode;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);

        System.out.println(getMid(node1).getValue());
        ListNode listNode = reverseList(node1);
        while (listNode != null) {
            System.out.print(listNode.getValue()+" ");
            listNode=listNode.getNext();
        }
    }
}
