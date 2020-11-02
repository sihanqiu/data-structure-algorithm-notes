package com.shq.yym.current.链表;

public class CircleLinkedList<E> extends AbstractList<E> {

    private ListNode<E> first; // 第一个元素的引用

    private ListNode<E> last; // 尾节点的引用

    private ListNode<E> current;

    public void reset() {
        current = first;
    }

    public E next() {
        if(current == null) return null;
        current = current.next;
        return current.element;
    }

    public E remove() {
        if(current == null) return null;
        ListNode<E> node = current.next;
        E element = remove(current);
        if(size == 0) {
            current = null;
        } else {
            current = node;
        }
        return element;
    }

    public E remove(ListNode<E> node) {

        E element = node.element;
        if(size == 1) {
            first = last = null;
        } else {
            ListNode<E> prev = node.prev;
            ListNode<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if(current == first) {
                first = next;
            }
            if(current == last) {
                last = prev;
            }
        }
        size--;
        return element;
    }

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
    /**
     * @Title: add
     * @Description:  双向循环链表 首节点的prev指向尾节点,尾节点的next指向首节点
     *               添加时考虑
     *               当向结尾添加节点
     *                size > 0 时
     *                  last.next = newNode(last, element, first)
     *                  last = last.next
     *                  first.prev = last;
     *                size == 0时
     *                  first = last = new(last, element, first)
     *                  first.prev = first.next = first;
     *               当其他结点添加元素
     *                 next = node(index)
     *                 prev = next.prev
     *                 next.prev = newNode(prev, element, next)
     *                 prev.next = next.prev;
     *                 即 index == 0
     *                   first = newNode(last, element, first);
     *                   last.next = first;
     *
     * @author sihanqiu
     * @date 2020/7/11
     * @param index
     * @param element
     * @return void
     */
    @Override
    public void add(int index, E element) {

        rangeCheckForAdd(index);
        if(index == size) {
            if(last == null) { //
                first = last = new ListNode<>(element);
                first.prev = first.next = first;
            } else {
                last.next = new ListNode<>(last, element, first);
                last = last.next;
                first.prev = last;
            }
        } else {
            ListNode<E> next = node(index);
            ListNode<E> prev = next.prev;
            next.prev = new ListNode<>(prev, element, next);
            prev.next = next.prev;

            if(prev == last) {
                first = next.prev;
            }
        }
        size++;
    }

    /**
     * @Title: remove
     * @Description: 双向循环链表删除元素 中间节点和双向链表一致
     *            删除单节点 双向循环链表时
     *              当size == 1时
     *                first = last = null；
     *            删除其他节点
     *              node = node(index)
     *              prev = node.prev
     *              next = node.next
     *              prev.next = next;
     *              next.prev = prev;
     *              当index = 0 即first == node
     *                 first = next;
     *              当last == node
     *                 last = prev;
     * @author sihanqiu
     * @date 2020/7/11
     * @param index
     * @return E
     */
    @Override
    public E remove(int index) {

        ListNode<E> node = node(index);
        return remove(node);
//        rangeCheck(index);
//        ListNode<E> node = first;
//        if(size == 1) {
//            first = last = null;
//        } else {
//            node = node(index);
//            ListNode<E> prev = node.prev;
//            ListNode<E> next = node.next;
//            prev.next = next;
//            next.prev = prev;
//            if (node == first) {
//                first = next;
//            }
//            if (node == last) {
//                last = prev;
//            }
//        }
//        size--;
//        return node.element;
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
