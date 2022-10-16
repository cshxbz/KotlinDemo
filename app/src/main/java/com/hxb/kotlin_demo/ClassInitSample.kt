package com.hxb.kotlin_demo


class ClassInitSample constructor(var propertyA: Int = 10) {

    var propertyB: String? = null
    var propertyC: Boolean? = null

    init {
        println("init 1 propertyA: $propertyA")
    }

    init {
        println("init 2 propertyA: $propertyA")
    }

    constructor(propertyA: Int, propertyB: String) : this(propertyA) {
        this.propertyB = propertyB
        println("secondary constructor 1")
    }

    constructor(propertyA: Int, propertyB: String, propertyC: Boolean) : this(propertyA, propertyB) {
        this.propertyC = propertyC
        println("secondary constructor 2")
    }


}