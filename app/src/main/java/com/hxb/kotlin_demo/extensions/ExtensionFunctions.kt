package com.hxb.kotlin_demo.extensions

import com.hxb.kotlin_demo.bean.Student


/**
 * Student类的扩展函数
 */
fun Student.fight(){
    /*
     * 这里的this关键字是实际调用此方法对象的引用
     */
    val stName = this.name

    println("student fight--$stNo--$name--$weight")
}

fun Student.talk(){
    println("student talk--$stNo--$name--$weight")
}
