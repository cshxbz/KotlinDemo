package com.hxb.kotlin_demo


class D : A, B, C() {

    override var pa: String = "pa_value"

    override var pc: String? = null

    /**
     * 从父类和实现的接口中继承了多个 f() 方法，所以必须
     * 通过强制override f() 方法来消除歧义
     */
    override fun f() {
        //用 super<类名>.方法名() 的形式来绝对调用继承的哪个实现
        super<A>.f()
        super<B>.f()
        super<C>.f()

    }

    override fun z() {

    }
}


interface A{

    var pa: String

    fun f(){
        println("A.f()")
    }

    fun x(){
        println("A.x()")
    }

}


interface B{

    fun f(){
        println("B.f()")
    }


    fun y(){
        println("B.y()")
    }

}


abstract class C {

    abstract val pc: String?

    open fun f(){
        println("C.f()")
    }

    abstract fun z()

}


