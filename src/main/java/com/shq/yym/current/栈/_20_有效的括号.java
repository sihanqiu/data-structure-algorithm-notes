package com.shq.yym.current.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: _20_有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 * @Description: 有效的括号
 * @author: sihanqiu
 * @date: 2020年07月13日 17:26
 */
public class _20_有效的括号 {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                if (map.get(stack.pop()) != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid1(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                if(s.charAt(i) == ']' && stack.pop() != '[') return false;
                if(s.charAt(i) == '}' && stack.pop() != '}') return false;
                if(s.charAt(i) == ')' && stack.pop() != '(') return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {

        while(s.contains("{}")
            || s.contains("[]")
            || s.contains("()")) {
            s.replace("{}", "");
            s.replace("[]", "");
            s.replace("()", "");
        }

        return s.isEmpty();
    }
}
