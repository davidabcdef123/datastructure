package com.david.stack;

import com.david.list.ListNode;
import com.sun.javafx.tk.DummyToolkit;

/**
 * @author: sun chao
 * Create at: 2019-07-21
 */
public class MyStack {

    public ListNode stackTop;
    private ListNode stackBottom;

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    /**
     * 进栈
     */
    public static void pushStack(MyStack myStack, int value) {
        ListNode node = new ListNode(value);
        node.setNext(myStack.stackTop);
        myStack.stackTop = node;
    }

    /**
     * 遍历
     */
    public static void traverse(MyStack myStack) {
        ListNode stackTop=myStack.stackTop;
        while (stackTop!=myStack.stackBottom) {
            System.out.print(stackTop.getValue() + " ");
            stackTop = stackTop.getNext();
        }
        System.out.println();
    }

    /**
     * 判短栈是否为空
     */
    public static boolean isEmpty(MyStack myStack) {
        if (myStack.stackTop == myStack.stackBottom) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 出栈
     */
    public static void popStack(MyStack myStack) {
        //myStack.stackTop=myStack.stackTop.getNext();

        if (!isEmpty(myStack)) {
            ListNode stackTop = myStack.stackTop;
            myStack.stackTop = stackTop.getNext();
            System.out.println(stackTop.getValue());
        }
    }

    /**
     * 清空栈
     */
    public static void clearStack(MyStack myStack) {
        myStack.stackTop=null;
        myStack.stackBottom = myStack.stackTop;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.stackBottom=myStack.stackTop;
        System.out.println(isEmpty(myStack));

        pushStack(myStack, 1);
        pushStack(myStack, 2);
        pushStack(myStack, 3);
        traverse(myStack);
        System.out.println(isEmpty(myStack));

        popStack(myStack);
        clearStack(myStack);
        System.out.println(isEmpty(myStack));
    }



}
