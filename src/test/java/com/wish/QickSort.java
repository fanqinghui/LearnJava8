package com.wish;

/**
     * 快速排序 
     * 
     */  
    public class QickSort {  
      
         public static void main(String[] args) {    
                int [] array = {6,4,7,3,1,8,2,9,5,3,2,10,5};
                quickSort(array, 0, array.length - 1);    
                for (int i = 0; i < array.length; i++) {    
                    System.out.println(array[i]);    
                }    
            }    
         public static void quickSort(int[] array,int left,int right){  
             int middle;  
             if(left<right){  
                 middle=getMiddle(array,left,right);//获得中间的位置  
                 quickSort(array,left,middle-1);//遍历左面的  
                 quickSort(array,middle+1,right);//遍历右面的  
             }  
         }  
         public static int getMiddle(int [] array,int left,int right){  
             int middleValue=array[left];  
             int middleIndex=left;  
             while(left<right){  
                 while(left < right && array[right]>=middleValue) right--;  
                 array[left]=array[right];  
                 while(left < right && array[left]<=middleValue) left++;  
                 array[right]=array[left];  
             }  
              
             if(left==right){//如果左右相等第一次遍历完成  
                 middleIndex=left;//left、right都可以  
                 array[middleIndex]=middleValue;//把中间值放到空缺位置  
                   
             }   
             return middleIndex;  
               
         }  
    }  