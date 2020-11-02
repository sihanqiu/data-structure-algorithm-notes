package com.shq.yym.current.链表;

public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断是否包含指定元素
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 添加元素到尾部
    public void add(E element) {
        add(size, element);
    }

    /**
     * 抛出异常
     * @param index
     */
    public void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 校验index索引是否越界
     * @param index
     */
    public void rangeCheck(int index) {
        if(index < 0 || index > size - 1) {
            outOfBounds(index);
        }
    }


    /**
     * 校验添加元素时 索引越界
     * @param index
     */
    public void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
