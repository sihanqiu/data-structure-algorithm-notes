package com.shq.yym.current.队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: _225_用队列实现栈  https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @Description: 225. 用队列实现栈
 * @author: sihanqiu
 * @date: 2020年07月16日 11:28
 */
public class _225_用队列实现栈 {

    Deque<Integer> elements;
    /** Initialize your data structure here. */
    public _225_用队列实现栈() {
        elements = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        elements.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return elements.pop();
    }

    /** Get the top element. */
    public int top() {
        return elements.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return elements.isEmpty();
    }
}
