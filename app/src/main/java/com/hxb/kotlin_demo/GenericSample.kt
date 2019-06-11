package com.hxb.kotlin_demo


/**
 * 泛型参数T声明为out,则T只能出现在输出位置（函数的返回值）
 */
interface Source<out T> {
    fun next(): T
}

/**
 * 泛型参数T声明为in,则T只能出现在输入位置（函数的参数）
 */
interface Comparable<in T>{
    fun compareTo(other: T): Int

}


interface Tag<T>{
    fun getContent(): T
    fun setContent(content: T)
}


fun genericTest1(tag: Tag<String>) {
    val other: Tag<out Any> = tag

    //编译出错误
//    other.setContent(1)

    other.getContent()
}

fun genericTest2(tag: Tag<Number>) {
    val other: Tag<in Int> = tag
    other.setContent(10)
    other.getContent()
}

fun genericOutTest(strs: Source<String>) {

    val objs: Source<Any> = strs

}

fun genericInTest(x: Comparable<Number>) {

    val d: Comparable<Double> = x

}


