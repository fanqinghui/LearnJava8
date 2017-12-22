package com.learn.java8.part3;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.learn.arithmetic.sort.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author fqh
 * @email fanqinghui100@126.com
 * @date 2017/12/13 9:35
 */
public class OptionalTest {

    public static void main(String[] argus){
        List<Student> students= Lists.newArrayList(new Student("a",100),new Student("b",90),new Student("c",80)
                ,new Student("d",70),new Student("e",60));
        System.out.println(getStr(students));
    }


    public static String getStr(List<Student> student){
        Optional<List<Student>> optional=Optional.ofNullable(student)/*.orElseThrow(new IllegalArgumentException(""))*/;
        if(optional.isPresent()){
            return Joiner.on(",").join(optional.get().stream().map(student1 -> student1.getName()).collect(Collectors.toList()));
        }else{
            return "";
        }


    }
}
