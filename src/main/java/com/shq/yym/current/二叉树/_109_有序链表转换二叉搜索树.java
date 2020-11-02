package com.shq.yym.current.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _109_有序链表转换二叉搜索树
 * @Description: 109. 有序链表转换二叉搜索树 https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @author: sihanqiu
 * @date: 2020年08月18日 13:55
 */
public class _109_有序链表转换二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public TreeNode sortedListToBST1(ListNode head) {

        TreeNode treeNode = new TreeNode();

        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        return sortedListToBST1(list, treeNode);
    }

    private TreeNode sortedListToBST1(List<Integer> list, TreeNode treeNode) {

        if(list.size() == 0) {
            return null;
        }
        int rootI = list.size() / 2;
        treeNode.val = list.get(rootI);
        treeNode.left = sortedListToBST1(list.subList(0, rootI), new TreeNode());
        treeNode.right = sortedListToBST1(list.subList(rootI + 1, list.size()), new TreeNode());

        return treeNode;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        TreeNode treeNode = new _109_有序链表转换二叉搜索树().sortedListToBST1(listNode);
        System.out.println(treeNode);
    }
}
