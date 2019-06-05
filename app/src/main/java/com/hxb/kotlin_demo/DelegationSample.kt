package com.hxb.kotlin_demo


interface ISubPart {
    var p1:Int

    fun f1()
    fun f2()
}


class SubPartA : ISubPart {
    override var p1: Int=100

    override fun f1() {
        println("SubPartA f1")
    }

    override fun f2() {
        println("SubPartA f2")
    }

}


class MainPart(val part: ISubPart) : ISubPart by part {

    fun f3() {
        println("MainPart f3")
    }

    override fun f1() {
        println("MainPart f1")
    }

}
