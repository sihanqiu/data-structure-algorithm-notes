package com.shq.yym.current.队列;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Deque
 * @Description: 双端队列
 * @author: sihanqiu
 * @date: 2020年07月14日 16:59
 */
public class Deque<E> {

    List<E> elements = new LinkedList<>();
    // 元素的数量
    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // 从队头入队
    public void enQueueFront(E element) {
        elements.add(0, element);
    }
    // 从队头出队
    public E delQueueFront() {
        return elements.remove(0);
    }
    // 从队尾入队
    public void enQueueRear(E element) {
        elements.add(element);
    }

    // 从队尾出队
    public E delQueueRear() {
       return elements.remove(elements.size() - 1);
    }
    // 获取队列的头元素
    public E front() {
        return elements.get(0);
    }
    // 获取队列的尾元素
    public E rear() {
        return elements.get(elements.size() - 1);
    }
    // 清空元素
    public void clear() {
        elements.clear();
    }
}
