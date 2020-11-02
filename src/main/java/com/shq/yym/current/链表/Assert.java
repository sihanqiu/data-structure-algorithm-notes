package com.shq.yym.current.链表;

/**
 * @ClassName: Assert
 * @Description: 测试
 * @author: sihanqiu
 * @date: 2020年07月10日 10:31
 */
public class Assert {

    public static void test(boolean b) {
        try{
            if(!b) throw new Exception("测试未通过！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
