package com.shq.yym.current;

import com.shq.yym.current.栈._42_接雨水;
import com.shq.yym.current.链表.Assert;
import com.shq.yym.current.链表.CircleLinkedList;
import com.shq.yym.current.链表.List;
import com.shq.yym.current.队列.CircleDeque;
import com.shq.yym.current.队列.CircleQueue;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Objects;
import org.springframework.util.StringUtils;

/**
 * @ClassName: Main
 * @Description: 测试主类
 * @author: sihanqiu
 * @date: 2020年07月10日 10:36
 */
public class Main {

    // 测试List的子类
    static void testList(List<Integer> list) {

//        LinkedList
        Objects.isNull(list);

        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Assert.test(list.indexOf(44) == 3);
        Assert.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Assert.test(list.contains(33));
        Assert.test(list.get(0) == 11);
        Assert.test(list.get(1) == 66);
        Assert.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    public static void josephus(int total, int num) {
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<>();
        for (int i = 1; i <= total; i++) {
            circleLinkedList.add(i);
        }

        circleLinkedList.reset();
        while(circleLinkedList.size() > 0) {
            for (int i = 1; i < num; i++) {
                circleLinkedList.next();
            }
            System.out.println(circleLinkedList.remove());
        }
    }

    public static void testCircleQueue() {
        CircleQueue<Integer> circleQueue = new CircleQueue<>();

        for (int i = 0; i < 10; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
        for (int i = 0; i < 5; i++) {
            circleQueue.delQueue();
        }

        System.out.println(circleQueue);

        for (int i = 15; i < 23; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
    }

    public static void testCircleDeque() {
        CircleDeque<Integer> circleDeque = new CircleDeque<>();

        for (int i = 0; i < 10; i++) {
            circleDeque.enQueueFront(i + 1);
            circleDeque.enQueueRear(i + 100);
        }
        System.out.println(circleDeque);
        for (int i = 0; i < 3; i++) {
            circleDeque.delQueueFront();
            circleDeque.delQueueRear();
        }
        System.out.println(circleDeque);
        circleDeque.enQueueFront(11);
        circleDeque.enQueueFront(22);
        System.out.println(circleDeque);

        while(!circleDeque.isEmpty()) {
            circleDeque.delQueueFront();
        }
    }
    public static void main(String[] args) {

//        testCircleDeque();
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

        linkedHashMap.put("c", 200);
        linkedHashMap.put("a", 300);
        linkedHashMap.put("d", 500);
        linkedHashMap.get("c");
        linkedHashMap.put("a", 100);

        for (Entry<String, Object> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
//        System.out.println(new _42_接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(new _42_接雨水().trap(new int[]{0, 1, 0, 2, 0, 2, 1,3, 0, 0, 0, 1}));
//        Stack<Integer> stack = new Stack<>();
//        stack.
//          System.out.println(new _150_逆波兰表达式求值().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
//        Deque<Integer> queue = new Deque<>();
//        queue.enQueueFront(11);
//        queue.enQueueFront(22);
//        queue.enQueueRear(33);
//        queue.enQueueRear(44);
//
//        while(!queue.isEmpty()) {
//            System.out.println(queue.delQueueRear());
//        }
    }

}
