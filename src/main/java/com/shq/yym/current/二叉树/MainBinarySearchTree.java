package com.shq.yym.current.二叉树;

import com.shq.yym.current.UserVo;
import java.util.Comparator;

/**
 * @ClassName: MainBinarySearchTree
 * @Description:
 * @author: sihanqiu
 * @date: 2020年07月28日 16:05
 */
public class MainBinarySearchTree {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{
            7, 4, 9, 2, 5, 8, 11, 3
        };

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            binarySearchTree.add(data[i]);
        }
        binarySearchTree.add(12);

        BinarySearchTree<UserVo> bst = new BinarySearchTree<>(
            Comparator.comparingInt(UserVo::getAge));
        bst.add(new UserVo(12));
        bst.add(new UserVo(15));

        System.out.println(bst);
    }
}
