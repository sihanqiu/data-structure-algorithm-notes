package com.shq.yym.current.队列;

import java.util.Stack;

/**
 * @ClassName: __用栈实现队列
 * @Description: 用栈实现队列  https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @author: sihanqiu
 * @date: 2020年07月14日 16:24
 */
public class _232_用栈实现队列 {

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public _232_用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void checkOutStack() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
