package com.shq.yym.current;

/**
 * @ClassName: UserVo
 * @Description:
 * @author: sihanqiu
 * @date: 2020年07月28日 16:06
 */
public class UserVo {

    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserVo(int age) {
        this.age = age;
    }

    public UserVo() {
    }

    public UserVo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
    }
}
