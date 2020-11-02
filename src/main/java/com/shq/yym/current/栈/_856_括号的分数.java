package com.shq.yym.current.栈;

/**
 * @ClassName: _856_括号的分数
 * @Description: 856. 括号的分数
 * @author: sihanqiu
 * @date: 2020年07月13日 18:03
 */
public class _856_括号的分数 {

    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 将初始分数入栈
        for (int i = 0; i < S.length(); i++) {
            if('(' == S.charAt(i)) {
                stack.push(0); // 遇到'(' 入栈0分
            } else {
                /**
                 * 遇到')' 时,
                 *   1. 完成一次匹配, 当前深度需要减一, 做出栈操作,
                 *   2. 栈顶元素即是当前深度分数, 深度减一, 相当于（S）得分就需要 *2 得到（S）的分数
                 *   3. 更新新的深度分数 原分数 + 下一深度即（')' 内深度）的得分 * 2 如S == 0 则（S）直接为1
                 *    ')' 内深度）的得分 即是栈顶元素
                 *    新的深度的 原分数  栈顶的第二个元素
                 *    弹出两次栈顶元素   n, p  再入栈 p + 2 * n
                 */
                int n = stack.pop(); // 当前深度的得分
                int p = stack.pop(); // 和上一深度的得分
                stack.push(p + (n == 0 ? 1 : 2 * n));
            }
        }
        return stack.pop();
    }

    public int scoreOfParentheses2(String S) {

        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (int i = 0; i < S.length(); i++) {
            if('(' == S.charAt(i)) {
                stack.push(0);
            } else {
                if(S.charAt(i - 1) == '(') {
                    score += Math.pow(2, stack.size() - 1);
                }
                stack.pop();
            }
        }
        return score;
    }

    public int scoreOfParentheses1(String S) {

        return F(S, 0, S.length());
    }

    public int F(String s, int i, int j) {

        int score = 0, sum = 0;
        for (int k = i; k < j; k++) {
            sum = sum + (s.charAt(k) == '(' ? 1 : -1);
            if(sum == 0) {
                if(k == i + 1) {
                    score++;
                } else {
                    score +=  2 * F(s, i + 1, k);
                }
                i = k + 1;
            }
        }
        return score;
    }
}
