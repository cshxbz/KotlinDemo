package com.hxb.kotlin_demo

class InnerClassSample {

    val propertyA: String = "abc"


    fun bar(){
        println("InnerClassSample bar")
    }


    /**
     * 嵌套类，无法访问外部类的成员（相当于java的static内部类）
     */
    class Nested {
        fun foo(){
            println("Nested foo")
        }
    }


    /**
     * 内部类，持有外部类的引用,可以访问外部类的成员
     */
    inner class Inner{
        fun foo(){
            println("Inner foo $propertyA")
            this@InnerClassSample.bar()
        }
    }



}