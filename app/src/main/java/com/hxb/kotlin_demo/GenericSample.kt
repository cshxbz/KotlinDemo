package com.hxb.kotlin_demo

import com.hxb.kotlin_demo.bean.Person
import com.hxb.kotlin_demo.bean.Student


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


fun genericOutTest(strs: Source<String>) {

    val objs: Source<Any> = strs

}

fun genericInTest(x: Comparable<Number>) {

    val d: Comparable<Double> = x

}


interface Tag<T>{
    fun getContent(): T
    fun setContent(content: T)
}


/**
 * 类型投影 out
 */
fun typeProjectionsOut(tag: Tag<String>) {
    val other: Tag<out Any> = tag

    //编译出错误
//    other.setContent(1)

    other.getContent()
}


/**
 * 类型投影 in
 */
fun typeProjectionsIn(tag: Tag<Number>) {
    val other: Tag<in Int> = tag
    other.setContent(10)
    other.getContent()
}


/**
 * 泛型上界约束
 */
class Room<P : Person>{
    var resident: P? = null
}

/**
 * 星投影
 */
fun genericConstraintsTest() {
    val room: Room<*> = Room<Student>()
    val resident = room.resident
}
