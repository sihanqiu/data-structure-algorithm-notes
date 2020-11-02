package com.shq.yym.current.队列;

/**
 * @ClassName: CircleQueue
 * @Description: 循环队列
 * @author: sihanqiu
 * @date: 2020年07月14日 14:54
 */
public class CircleQueue<E> {

    private int front;

    private int size;

    private E[] elements;

    public static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // 元素的数量
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    } // 判断队列是否为空
    public void enQueue(E element) {

        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    } // 入队

    public E delQueue() {
        E element = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return element;
    } // 出队

    public E front() {
        return elements[front];
    }// 获取队列的头元素

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    } // 清空元素

    private int index(int index) {
        index += front;
        return index - (elements.length > index ? 0 : elements.length);
    }
    /**
     * 保证 容量 添加元素时自动扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {

        int oldCapacity = elements.length;
        if(oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[index(i)];
        }

        elements = newElements;
        front = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Front: ").append(front)
            .append("  Size: ").append(size)
            .append("  Capacity: ").append(elements.length)
            .append(", [");
        for (int i = 0; i < elements.length; i++) {
            if(i != 0) {
                str.append(", ");
            }
            str.append(elements[i]);
        }
        str.append("]");
        return str.toString();
    }
}
