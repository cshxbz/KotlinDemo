package com.hxb.kotlin_demo

import com.hxb.kotlin_demo.bean.Person

class ObjectExpressionSample {

    fun receiverPersonObj(p: Person) {
        p.walk()
        p.eat()
    }


    /**
     * 可以创建一个匿名类对象，不需要通过继承任何父类
     */
    fun customObj(): Any {
        val obj = object {
            val pa: Int = 15
            val pb: String = "kkk"

            fun f() {
                println("customObj f")
            }
        }

        obj.f()

        return obj
    }


    /**
     * 匿名类对象作为一个方法的返回值的情况，
     * 如果此方法是private的，那么返回值是实际的匿名类对象类型（也就是说可以访问匿名类对象中定义的成员）
     * 如果此方法是非private的，那么返回值是匿名类对象的父类，如果无父类，返回类型就是Any
     */
    private fun returnCustomObj() = object {
        fun x() {
            println("x")
        }
    }


    fun boo(){
        val customObj = returnCustomObj()
        customObj.x()
    }


}