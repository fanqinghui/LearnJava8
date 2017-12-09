package com.learn.arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序，每次相邻的元素进行比较，谁比较小就交换位置，把小的排到后面。每次一轮比较都会确定一个最小值
 * 时间复杂度：O(N的2次方)
 * 10w份数据 共运行六次平均用时在90秒(68720ms)左右 ,跟桶排序部署一个级别
 * i5 4核 2.5Hz 12G内存
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/7 14:53
 */
public class BubbleSort {


    /**
     * 10分满分，情况下，從小到大排序
     * @param argus
     */
    public static void main(String[] argus){

        Student[] init=new Student[100001];
        for(int i=0;i<=100000;i++){
           init[i]= new Student("小红"+i,new Random().nextInt(100));
        }
        Long beginTime=System.currentTimeMillis();
        sort(init);
        Long endTime=System.currentTimeMillis();
        System.out.println("10w份数据耗时："+(endTime-beginTime)+"ms");
        /*Arrays.stream(init).forEach(student -> print(student));
        System.out.println("soft end");
        Arrays.stream(sort(init)).forEach(student -> print(student));*/
    }

    public static Student[] sort(Student[] values){

        int length=values.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length-1;j++){
                if(values[i].getSocre()>values[j].getSocre()){
                    Student temp=values[i];
                    values[i]=values[j];
                    values[j]=temp;
                }
            }
        }
        return values;
    }

    private static void print(Student stu){
        System.out.println(stu);
    }
}
