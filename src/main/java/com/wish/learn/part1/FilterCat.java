package com.wish.learn.part1;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/8/15 11:10
 */
public class FilterCat {

    //guava方式创建
    /*List<Cat> cats2=Lists.newArrayList(new Cat("白猫","中华狸猫"),
            new Cat("黑猫","中华狸猫"),
            new Cat("黄猫","菊猫"));*/

    public static void main(String[] arugs){
        List<Cat> cats= Arrays.asList(new Cat("白猫","中华狸猫"),
                new Cat("黑猫","中华狸猫"),
                new Cat("黄猫","菊猫"));

        List<Cat> result=zhonghualimao(cats);
        System.out.println(result);

    }

    //是否中华狸猫
    public static boolean isZhonghualimao(Cat cat){
        if(Objects.equal("中华狸猫",cat.getType())){
            return true;
        }
        return false;
    }

    //是否中华狸猫
    public static List<Cat> zhonghualimao(List<Cat> cats){
        List<Cat> catList=Lists.newArrayList();
        if(cats==null || cats.size()==0){
            return catList;
        }
        for(Cat cat:cats){
            if(Objects.equal("中华狸猫",cat.getType())){
                catList.add(cat);
            }
        }
        return catList;
    }

    /**
     * 猫 颜色，种类
     */
    static class Cat{
        private String color;
        private String type;

        public Cat(String color, String type) {
            this.color = color;
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "type='" + type + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}



