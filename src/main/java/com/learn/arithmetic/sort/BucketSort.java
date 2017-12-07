package com.learn.arithmetic.sort;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/7 10:30
 */
public class BucketSort {


    /**
     * 10分满分，情况下，排序
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
        /*Iterator<List<Student>> result=sort(init);
        while (result.hasNext()){
            List<Student> lists=result.next();
            lists.stream().forEach(student -> {
                System.out.println(student);
            });
        }*/
        //int[] result=sort(init);
        /*Arrays.stream(result).forEach(o->{
            for(;o>0;o--){
             System.out.print(+"   ");
            }
        });*/

       /* for(int i=result.length-1;i>0;i--){
            for(int j=0;j<result[i];j++){
                System.out.print(i+" ");
            }
            System.out.println("");
        }*/
       Arrays.sort(init);
        Arrays.stream(init).forEach(student -> {
            System.out.println(student);
        });

    }
      public static int[] sort(Student[] values){
           int[] result=new int[11];
           Arrays.stream(values).forEach(student -> {
               result[student.getSocre()]=result[student.getSocre()]+1;
           });
            /*List<List<Student>> results= new ArrayList<>(11);
            Arrays.stream(values).forEach(student -> {
                List<Student> ls=results.get(student.getSocre());
                if(ls==null ||ls.size()<=0){
                    ls=Lists.newArrayList();
                }
                ls.add(student);
                results.set(student.getSocre(),ls);
            });
            return results.iterator();*/
            return result;
        }


    /*public static Iterator<List<Student>> sort(Student[] values){
        //Student[] result=new Student[11];
        List<List<Student>> results= new ArrayList<>(11);
        Arrays.stream(values).forEach(student -> {
            List<Student> ls=results.get(student.getSocre());
            if(ls==null ||ls.size()<=0){
                ls=Lists.newArrayList();
            }
            ls.add(student);
            results.set(student.getSocre(),ls);
        });
        return results.iterator();
    }*/

    static class Student implements Comparable<Student>{
        String name;
        int socre;

        public Student(String name, int socre) {
            this.name = name;
            this.socre = socre;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSocre() {
            return socre;
        }

        public void setSocre(int socre) {
            this.socre = socre;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", socre=" + socre +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            if(this.getSocre()==o.getSocre()) {return 0;}

            return this.getSocre()>o.getSocre()?1:-1;
        }
    }

}
