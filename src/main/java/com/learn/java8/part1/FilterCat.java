package com.learn.java8.part1;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
/*
        List<Cat> result=zhonghualimao(cats);
        System.out.println(result);*/

        List<Cat> catList=cats.stream().filter(Cat::isLiCat).collect(Collectors.toList());
        catList.stream().forEach(cat -> {
            System.out.println(cat);
        });

        catList.stream().forEach(cat -> System.out.println(cat));

        new Thread(() -> System.out.println("xx")).start();

        new Thread(()->System.out.println("yy")).start();

    }

    //是否中华狸猫
    public static void print(Cat cat){
       System.out.println(cat);
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

        public boolean isLiCat(){
            if(java.util.Objects.equals(this.type, "中华狸猫")) {
                return true;
            }
            return false;
        }
    }
}



