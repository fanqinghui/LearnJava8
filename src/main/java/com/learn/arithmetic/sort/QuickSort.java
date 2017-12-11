package com.learn.arithmetic.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分法快速排序
 * O（logN）
 * 100w条数据也才200毫秒左右
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/8 10:09
 */
public class QuickSort {

    public static void main(String[] argus){
        int[] initArr=new int[1000000];
        for(int i=0;i<1000000;i++){
            initArr[i]=new Random().nextInt(1000000);
        }
        //Arrays.stream(initArr).forEach(i->print(i));
        Long beginTime=System.currentTimeMillis();
        sort(initArr,0,initArr.length-1);
        Long endTime=System.currentTimeMillis();
        System.out.println("100w份数据耗时："+(endTime-beginTime)+"ms");
        //Arrays.stream(initArr).forEach(i->print(i));

    }

    /**
     * 二分法思路,每次确定一个基数，然后从左端i找比基数大的 右端j开始找比基数小的，直到都找到，进行交换。每轮i与j碰见才结束
     * @param initArr
     * @return
     */
   public static void sort(int[] initArr,int left,int right){
       int middle;
       //判断
        if(left<=right){
            middle=getMiddleAndSwap(initArr,left,right);//先进行一轮交换，确定中间值
            //确定一个基点
            //左右拆封继续
            sort(initArr,left,middle-1);//左
            sort(initArr,middle+1,right);//右
        }
   }

    /**
     * 进行数据交换，并且返回中间指
     * @param initArr
     * @param left
     * @param right
     * @return
     */
    public static int getMiddleAndSwap(int[] initArr,int left,int right){
        int middleValue=initArr[left];
        int middle=left;
        while (left<right){//左边找到一个比middle大的，停止，右边找到一个比middle小的停止，两个停止的位置进行数据交换
            while (left<right && initArr[right]>=middleValue){right--;}
            initArr[left]=initArr[right];
            while (left<right && initArr[left]<=middleValue){left++;}
            initArr[right]=initArr[left];
        }

        //交換完畢--交换基值
        //if(left==right) {
            middle = left;
            initArr[left] = middleValue;
        //}
        return middle;
    }

    public static void print(int i){
       System.out.print(i+" ");
    }
}
