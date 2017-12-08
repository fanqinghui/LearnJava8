package com.learn.arithmetic.sort;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 桶排序， 缺点是非常浪费空间，排序速度很快，时间复杂度为O（m+n）m为桶的个数，n是待排序的个数
 *  @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/7 10:30
 */
public class BucketSort {


    /**
     * 10分满分，情况下，從小到大排序
     * @param argus
     */
    public static void main(String[] argus){

        Student[] init=new Student[]{
                new Student("小红",8),
                new Student("小张",3),
                new Student("小赵",10),
                new Student("小李",4),
                new Student("小衣",3),
                new Student("小明",6)
        };
        Arrays.stream(init).forEach(student -> {
            System.out.println(student);
        });
        System.out.println("soft end");
        Iterator<List<Student>> result=sort(init);
        while (result.hasNext()){
            List<Student> lists=result.next();
            lists.stream().forEach(student -> {
                System.out.println(student);
            });
        }
    }

    public static Iterator<List<Student>> sort(Student[] values){
        List<List<Student>> results= Lists.newArrayList(
                Lists.newArrayList(),Lists.newArrayList(),
                Lists.newArrayList(),Lists.newArrayList(),
                Lists.newArrayList(),Lists.newArrayList(),
                Lists.newArrayList(),Lists.newArrayList(),
                Lists.newArrayList(),Lists.newArrayList(),
                Lists.newArrayList());

        Arrays.stream(values).forEach(student -> {
            int index=results.size()-student.getSocre();
            List<Student> ls=results.get(index);
            ls.add(student);
            results.set(index,ls);
        });
        return results.iterator();
    }
}
