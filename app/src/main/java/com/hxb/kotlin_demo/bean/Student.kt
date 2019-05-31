package com.hxb.kotlin_demo.bean

open class Student constructor(name: String, var stNo: String) : Person(name) {

    init {
        println("Student init")
    }

    public constructor(name: String, age: Int, weight: Float, stNo: String) : this(name, stNo) {
        super.age=age
        super.weight=weight
    }


    final override fun walk() {
        super.walk()
        println("Student walk")
    }

    override fun eat() {
        println("Student eat")

    }
}