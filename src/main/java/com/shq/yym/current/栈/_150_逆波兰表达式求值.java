package com.shq.yym.current.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _150_逆波兰表达式求值
 * @Description: 150. 逆波兰表达式求值
 * @author: sihanqiu
 * @date: 2020年07月15日 16:56
 */
public class _150_逆波兰表达式求值 {

    enum type {
        JIA("+"),
        JIAN("-"),
        CHENG("*"),
        CHU("/");
        private String name;

        type(String name) {
            this.name = name;
        }

        static List<String> list() {

            List<String> list = new ArrayList<>();
            type[] values = type.values();
            for (type value : values) {
                list.add(value.name);
            }
            return list;
        }
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if(!(type.list().contains(token))) {
                stack.push(Integer.parseInt(token));
            } else {
                int w = stack.pop();
                int v = stack.pop();
                if(type.JIA.name.equals(token)) {
                    stack.push(v + w);
                } else if(type.JIAN.name.equals(token)) {
                    stack.push(v - w);
                } else if(type.CHENG.name.equals(token)) {
                    stack.push(v * w);
                } else if(type.CHU.name.equals(token)) {
                    stack.push(v / w);
                }
            }
        }
        return stack.pop();
    }
}
