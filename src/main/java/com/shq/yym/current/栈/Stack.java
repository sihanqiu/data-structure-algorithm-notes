package com.shq.yym.current.栈;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Stack
 * @Description: 栈
 * @author: sihanqiu
 * @date: 2020年07月13日 14:45
 */
public class Stack<E> {

    private List<E> elements = new ArrayList<>();

    public void clear() {
        elements.clear();
    }
    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(E element) {
        elements.add(elements.size(), element);
    }

    public E pop() {
        return elements.remove(elements.size() - 1);
    }

    public E peek() {
        return elements.get(elements.size() - 1);
    }
}
