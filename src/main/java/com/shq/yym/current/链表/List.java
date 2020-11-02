package com.shq.yym.current.链表;

public interface List<E> {

    // 查找不到元素时返回的值
    int ELEMENT_NOT_FOUND = -1;

    // 清除所有元素
    void clear();

    // 获取元素的数量
    int size();

    // 判断是否为空
    boolean isEmpty();

    // 获取指定位置元素的值
    // 参数元素的索引
    E get(int index);

    // 设置指定位置元素的值
    // 返回原来元素的值
    E set(int index, E element);

    // 查看元素的索引
    int indexOf(E element);

    // 判断是否包含指定元素
    boolean contains(E element);

    // 添加元素到尾部
    void add(E element);


    /**
     * 添加元素到指定位置
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 抛出异常
     * @param index
     */
    void outOfBounds(int index);

    /**
     * 校验index索引是否越界
     * @param index
     */
    void rangeCheck(int index);


    /**
     * 校验添加元素时 索引越界
     * @param index
     */
    void rangeCheckForAdd(int index);

    /**
     * @Title: remove
     * @Description:
     * @author sihanqiu
     * @date 2020/6/30
     * @param index
     * @return int
     */
    E remove(int index);
}
