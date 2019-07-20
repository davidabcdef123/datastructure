package com.david.list;

/**
 */
public class MyList {

    /**
     * 头结点的插入(头部插入)
     */
    public static void headAdd(ListNode headNode, ListNode addNode) {
        ListNode old = headNode;
        headNode = addNode;
        headNode.setNext(old);
    }

    /**
     * 尾部结点的插入
     */
    public static void tailAdd(ListNode tailNode, ListNode addNode) {
        ListNode old = tailNode;
        tailNode = addNode;
        tailNode.setNext(null);
        old.setNext(tailNode);
    }

    /**
     * 遍历
     */
    public static void transerse(ListNode headNode) {
        while (headNode != null) {
            System.out.print(headNode.getValue() + " ");
            headNode = headNode.getNext();
        }
        System.out.println();
    }

    /**
     * 查找
     */
    public static int find(ListNode headNode, int value) {
        int notFind = -1;
        int index = 0;
        while (headNode != null) {
            if (headNode.getValue() == value) {
                return index;
            }
            index++;
            headNode = headNode.getNext();
        }
        return notFind;
    }

    /**
     * 插入结点
     */
    public static void insert(ListNode anyNode, ListNode addNode) {
        ListNode oldNextNode = anyNode.getNext();
        addNode.setNext(oldNextNode);
        anyNode.setNext(addNode);
    }

    /**
     * 删除
     */
    public static void delete(ListNode head, ListNode delNode) {

        while (head != null && head.getNext() != null) {
            if (head.getNext().getValue() == delNode.getValue()) {
                ListNode newAfter = head.getNext().getNext();
                head.setNext(newAfter);
                break;
            }
            head = head.getNext();
        }
    }

    public static void delete2(ListNode head, ListNode delNode) {
        //非最后一个结点
        if (delNode != null && delNode.getNext() != null) {
            //4
            ListNode p = delNode.getNext();
            //
            delNode.setValue(p.getValue());
            //删除掉delNode.next
            delNode.setNext(p.getNext());
            p = null;
        }
        //删除最后一个元素的情况
        if (delNode.getNext() == null) {
            while (head != null) {
                if (head.getNext() != null && head.getNext() == delNode) {
                    head.setNext(null);
                    break;
                }
                head=head.getNext();
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);
        transerse(node1);
        ListNode newHead=new ListNode(0);
        headAdd(node1, newHead);
        transerse(newHead);
        ListNode newTail = new ListNode(4);
        tailAdd(node3,newTail);
        transerse(newHead);
        System.out.println("查询的下标="+find(newHead,4));
        ListNode addnode = new ListNode(5);
        insert(node3,addnode);
        transerse(newHead);
        delete(newHead, node3);
        transerse(newHead);
    }
}
