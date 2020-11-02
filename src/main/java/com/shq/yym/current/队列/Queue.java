package com.shq.yym.current.队列;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Queue
 * @Description: 队列
 * @author: sihanqiu
 * @date: 2020年07月14日 14:54
 */
public class Queue<E> {

    List<E> elements = new LinkedList<>();
    // 元素的数量
    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    } // 判断队列是否为空
    public void enQueue(E element) {
        elements.add(element);
    } // 入队
    public E delQueue() {
        return elements.remove(0);
    } // 出队

    public E front() {
        return elements.get(0);
    }// 获取队列的头元素
    public void clear() {
       elements.clear();
    } // 清空元素
}
