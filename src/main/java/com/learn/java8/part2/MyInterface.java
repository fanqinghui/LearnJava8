package com.learn.java8.part2;

/**
 * lamda
 * +
 * 展示默认方法
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/12 16:22
 */
@FunctionalInterface
public interface MyInterface {

    default String get(){
        return "write my default";
    }

    public void writeGet();
}
