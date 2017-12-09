package com.learn.arithmetic.sort;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.*;

/**
 *
 * 桶排序， 缺点是非常浪费空间，排序速度很快，时间复杂度为O（m+n）m为桶的个数，n是待排序的个数 *
 * 10w份数据 共运行六次平均用时在150ms左右
 * i5 4核 2.5Hz 12G内存
 *  @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/7 10:30
 */
public class BucketSort2 {


    /**
     * 10分满分，情况下，從小到大排序
     * @param argus
     */
    public static void main(String[] argus){

        Student[] init=new Student[100000];
        for(int i=0;i<100000;i++){
            init[i]= new Student("小红"+i,new Random().nextInt(100000)+1);
        }
        Long beginTime=System.currentTimeMillis();
        List<List<Student>> result=sort(init);
        Long endTime=System.currentTimeMillis();
        System.out.println("100w份数据耗时："+(endTime-beginTime)+"ms");
    }

    public static List<List<Student>> sort(Student[] values){
        List<List<Student>> results=new ArrayList<>();
        for(int i=0;i<=100001;i++){
            results.add(i,Lists.newArrayList());
        }
        int size=results.size();
        Arrays.stream(values).forEach(student -> {
            int index=size-student.getSocre();
            //System.out.println(index+"=size:"+size+"-score:"+student.getSocre());
            List<Student> ls=results.get(index);
            ls.add(student);
            results.set(index,ls);
        });
        return results;
    }
}
