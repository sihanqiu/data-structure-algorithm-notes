package com.shq.yym.current.二叉树;

import java.util.Comparator;

/**
 * @ClassName: BinarySearchTree
 * @Description: 二叉搜索树的实现
 * @date: 2020年07月27日 21:12
 * @author: sihanqiu
 */
public class BinarySearchTree<E> {

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    // 元素的数量
    public int size() {
        return size;
    }
    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空所有元素
    public void clear() {

    }

    // 添加元素
    /**
     * 添加元素
     * 找到父节点
     * 创建新节点
     * 将parent.left = newNode 或者 parent.right = newNode
     * 遇到相等的值，建议覆盖旧值
     * @param element
     */
    public void add(E element) {
        elementNotNullCheck(element);

        if(root == null) {
            root = new Node<>(null, element);
            size++;
            return;
        }

        Node<E> parent = root;
        Node<E> node = root;
        while(node != null) {
            parent = node;
            if(compare(element, node.element) > 0) {
                node = node.right;
            } else if (compare(element, node.element) < 0) {
                node = node.left;
            } else {
//                node.element = element;
                return;
            }
        }
        if(compare(element, parent.element) > 0) {
            parent.right = new Node<>(parent, element);
        } else if (compare(element, parent.element) < 0) {
            parent.left = new Node<>(parent, element);
        }
        size++;
    }

    /**
     * 比较方法
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {

        if(comparator == null) {
            return ((Comparable)e1).compareTo(e2);
        }
        return comparator.compare(e1, e2);
    }

    /**
     * 检验元素值是否为空
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null!!!");
        }
    }

    // 删除元素
    public E remove(E element) {
        return element;
    }

    // 是否包含元素
    boolean contains(E element) {
        return true;
    }


    private static class Node<E> {

        private Node<E> left;

        private Node<E> right;

        private Node<E> parent;

        private E element;

        public Node(Node<E> parent, E element) {
            this.parent = parent;
            this.element = element;
        }
    }
}
