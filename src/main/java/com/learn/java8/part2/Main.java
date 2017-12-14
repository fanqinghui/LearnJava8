package com.learn.java8.part2;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/12 16:27
 */
public class Main {

    public static void main(String[] argus){
        MyInterface myInterface=new My();
        MyInterface youInterface=new You();
        print(myInterface);
        print(youInterface);
    }

    public static void print(MyInterface myInterface){
        myInterface.writeGet();
    }
}
