package com.shq.yym.current.队列;

/**
 * @ClassName: Deque
 * @Description: 双端队列
 * @author: sihanqiu
 * @date: 2020年07月14日 16:59
 */
public class CircleDeque<E> {

    private int front;

    private int size;

    private E[] elements;

    public static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // 元素的数量
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 从队头入队
    public void enQueueFront(E element) {

        ensureCapacity(size + 1);
        elements[index(-1)] = element;
        front = index(-1);
        size++;
    }
    // 从队头出队
    public E delQueueFront() {
        E element = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return element;
    }
    // 从队尾入队
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    // 从队尾出队
    public E delQueueRear() {

        int index = index(size - 1);
        E element = elements[index];
        elements[index] = null;
        size--;
        return element;
    }
    // 获取队列的头元素
    public E front() {
        return elements[front];
    }
    // 获取队列的尾元素
    public E rear() {
        return elements[index(size - 1)];
    }
    // 清空元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    }

    private int index(int index) {
        index += front;
        if(index < 0) {
            return index + elements.length;
        }
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
