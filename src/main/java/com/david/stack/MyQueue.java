package com.david.stack;

import java.util.Queue;

/**
 * @author: sun chao
 * Create at: 2019-07-21
 */
public class MyQueue {
    public int[] arrays;
    public int front;//指向第一个有效元素
    public int rear;// 指向最后一个有效元素的下一个元素（无效元素）

    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    /**
     * 判短是否满
     */
    public static boolean isFull(MyQueue myQueue) {
        if ((myQueue.rear + 1) % myQueue.arrays.length == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判短是否为空
     */
    public static boolean isEmpty(MyQueue myQueue) {
        if (myQueue.rear == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 入队
     */
    public static void enterQueue(MyQueue myQueue, int value) {
        if (!isFull(myQueue)) {
            myQueue.arrays[myQueue.rear] = value;
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length;
        }
    }

    /**
     * 遍历
     */
    public static void traverse(MyQueue myQueue) {
        int i = myQueue.front;
        while (i != myQueue.rear) {
            System.out.print(myQueue.arrays[i] + " ");
            i = (i + 1) % myQueue.arrays.length;
        }
        System.out.println();
    }

    /**
     * 出队
     */
    public static void outQueue(MyQueue myQueue) {
        if (!isEmpty(myQueue)) {
            int value = myQueue.arrays[myQueue.front];
            System.out.println(value);
            myQueue.front = (myQueue.front + 1) % myQueue.arrays.length;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue));
        enterQueue(myQueue, 1);
        enterQueue(myQueue, 2);
        enterQueue(myQueue, 3);
        enterQueue(myQueue, 4);
        enterQueue(myQueue, 5);
        System.out.println(isFull(myQueue));

        traverse(myQueue);
        outQueue(myQueue);

    }


}
