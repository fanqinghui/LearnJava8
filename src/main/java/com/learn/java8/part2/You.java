package com.learn.java8.part2;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/12 16:25
 */
public class You implements MyInterface {


    @Override
    public String get() {
        return "write you get";
    }

    @Override
    public void writeGet() {
        System.out.println(this.get());
    }
}
