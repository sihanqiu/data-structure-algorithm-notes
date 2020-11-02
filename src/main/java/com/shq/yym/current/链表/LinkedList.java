package com.shq.yym.current.链表;

public class LinkedList<E> extends AbstractList<E> {

    private ListNode<E> first; // 第一个元素的引用

    private ListNode<E> last; // 第一个元素的引用

    @Override
    public void clear() {
        first = null;
        last = null;
        // 单向链表  只需要将first 设为null gc会自动回收  元素资源
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
        ListNode<E> node = first;
        if(index < (size >> 1)) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
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
        if(index == size) {
            if(last == null) { //
                first = last = new ListNode<>(element);
            } else {
                last = new ListNode<>(last, element, null);
                last.prev.next = last;
            }
        } else {
            ListNode<E> node = node(index);
            ListNode<E> prev = node.prev;
            node.prev = new ListNode<>(node.prev, element, node);
            if(prev == null) {
                first = node.prev;
            } else {
                prev.next = node.prev;
            }

        }
        size++;
    }

    @Override
    public E remove(int index) {

        ListNode<E> node = node(index);
        ListNode<E> prev = node.prev;
        ListNode<E> next = node.next;
        if(prev == null) {
            first = first.next;
        } else {
            prev.next = next;
        }
        if(next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
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

        private ListNode<E> prev;

        private E element; // 节点元素内容

        private ListNode<E> next; // 下一个元素的引用

        public ListNode() {
        }

        public ListNode(E element) {
            this.element = element;
        }

        public ListNode(ListNode<E> prev, E element, ListNode<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder strB = new StringBuilder();
            if(prev != null) {
                strB.append(prev.element).append("_");
            } else {
                strB.append("null").append("_");
            }
            strB.append(element);
            if(next != null) {
                strB.append("_").append(next.element);
            } else {
                strB.append("_").append("null");
            }
            return strB.toString();
        }
    }
}
