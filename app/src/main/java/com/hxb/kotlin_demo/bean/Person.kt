package com.hxb.kotlin_demo.bean

open class Person constructor(var name: String) {

    var age: Int? = null
    var weight: Float? = null

    init {
        println("Person init")
    }

    public constructor(name: String, age: Int) : this(name) {
        this.age = age
    }

    public constructor(name: String, age: Int, weight: Float) : this(name, age) {
        this.weight = weight
    }


    public open fun walk() {
        println("Person walk")
    }

    public open fun eat() {
        println("Person eat")
    }


    /**
     * 非data类如果要使用结构声明，需要有componentN方法
     */
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int? {
        return this.age
    }

}