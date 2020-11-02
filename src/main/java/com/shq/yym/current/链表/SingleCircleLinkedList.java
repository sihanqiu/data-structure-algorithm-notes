package com.shq.yym.current.链表;

public class SingleCircleLinkedList<E> extends AbstractList<E> {

    private ListNode<E> first; // 第一个元素的引用

    @Override
    public void clear() {
        first = null;   // 单向链表  只需要将first 设为null gc会自动回收  元素资源
        // 源码中 也可以将元素的next 设为null
        size = 0;
    }

    @Override
    public E get(int index) {

        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        ListNode<E> node = node(index);
        E e = node.element;
        node.element = element;
        return e;
    }

    private ListNode<E> node(int index) {

        rangeCheck(index);
        ListNode<E> node = first;  // first 为初始元素  index == 0 时 就返回first
        for (int i = 0; i < index; i++) {  // 获取index位置，循环向下查找index - 1次
            node = node.next;
        }
        return node;
    }

    @Override
    public int indexOf(E element) {

        ListNode<E> node = first;  // first 为初始元素  index == 0 时 就返回first
        for (int i = 0; i < size; i++) {  // 获取index位置，循环向下查找index - 1次
            if(node.element == element) return i;
            node = node.next;
        }
        return ELEMENT_NOT_FOUND;
    }

    // 在index位置添加元素
    @Override
    public void add(int index, E element) {

        rangeCheckForAdd(index);
        if(index == 0) {
            first = new ListNode<>(element, first);
            if(size == index){ // 当添加第一个元素时，将它的next只想自己
                first.next = first;
            }
        } else {
            ListNode<E> pre = node(index - 1);
            pre.next = new ListNode<>(element, pre.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {

        rangeCheck(index);
        E del = first.element;
        if(index == 0) {
            if(size == 1) {
                first = null;
            } else {
                ListNode<E> node = node(size - 1);
                first = first.next;
                node.next = first;
            }
        } else {
            ListNode<E> node = node(index - 1);
            del = node.next.element;
            node.next = node.next.next;
        }
        size--;
        return del;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Size: ").append(size).append(", [");
        ListNode<E> node = first;
        for (int i = 0; i < size; i++) {
            if(i != 0) { // 相比判断最后一个元素不加“，”， 少一个执行
                str.append(",");
            }
            str.append(node);
            node = node.next;
        }
        str.append("]");
        return str.toString();
    }

    public static class ListNode<E> {

        private E element; // 节点元素内容

        private ListNode<E> next; // 下一个元素的引用

        public ListNode() {
        }

        public ListNode(E element) {
            this.element = element;
        }

        public ListNode(E element, ListNode<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder strB = new StringBuilder();
            strB.append(element);
            if(next != null) {
                strB.append("_").append(next.element);
            }
            return strB.toString();
        }
    }
}
