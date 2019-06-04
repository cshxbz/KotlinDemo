package com.hxb.kotlin_demo


interface Source<out T> {
    fun next(): T
}


fun bar(strs: Source<String>) {

    val objs: Source<Any> = strs

}


