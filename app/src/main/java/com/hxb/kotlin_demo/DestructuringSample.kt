package com.hxb.kotlin_demo

import com.hxb.kotlin_demo.bean.Person

/**
 * 解构声明
 */
class DestructuringSample {

    fun test() {
        val p = Person(name = "muller", age = 15)
        val (a, b) = p

        println("$a--$b")
    }
}