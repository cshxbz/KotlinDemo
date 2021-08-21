package com.hxb.kotlin_demo;

import com.hxb.kotlin_demo.bean.Person;
import com.hxb.kotlin_demo.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class JavaGenericSample {

    private void x(){
        List<? extends Person> list1 = new ArrayList<Student>();
        List<? super Student> list2 = new ArrayList<Person>();

        list2.add(new Student("erika", "001"));
        Object item = list2.get(0);
    }


}
