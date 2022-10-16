package com.hxb.kotlin_demo

class MethodSample {


    var listener: ((a: Int, b: Int) -> Unit)? = null

    /**
     * lambda表达式中只有一个参数，该参数隐式声明为it
     */
    public val onlyOneParamLambda: (String) -> Int = {
        it.length
    }

    /**
     * 带有接收者的lambda
     */
    public val withReceiverLambda: Int.(Int) -> Int = {
        //可用this关键字访问接收者
        println("receiver: $this")
        //可直接调用接受者的方法
        plus(it)
    }



    /**
     * 简单的带有返回值的函数
     */
    public fun plainFunction(i: Int, str: String): String {
        return "plainFunction return : $i-$str"
    }


    /**
     * 参数列表中有函数的函数
     */
    public fun withFunParamFunction(i: Int, str: String, action: (actionParams1: Int, actionParams2: String) -> String): String {
        val actionReturn = action(2, "b")
        println("withFunParamFunction actionReturn : $actionReturn")
        return "withFunParamFunction return : $i-$str"
    }


    /**
     * 只有一个函数作为参数的函数
     */
    public fun onlySingleFunParamFunction(operation: (num1: Int, num2: Int) -> Int) {
        val result = operation(2, 4)
        println("onlySingleFunParamFunction operation return : $result")
    }


    /**
     * 带有默认参数值的方法
     */
    fun withDefaultParams(p1: String = "p1_default_value", p2: String) {
        println("$p1 -- $p2")
    }


    /**
     * 可变长度参数
     */
    fun varArgFunction(vararg strArray: String) {
        val array = strArray
    }


    /**
     * 局部函数：在函数中定义函数
     */
    fun localFunctions() {
        val number = 1
        fun foo() {
            println("foo $number")
        }
        //调用局部函数
        foo()

    }


    fun test() {
        listener?.invoke(1, 2)

        varArgFunction("1", "2", "2")

        withDefaultParams(p2 = "")

        withFunParamFunction(i = 1, str = "xxx") { actionParams1: Int, actionParams2: String ->
            return@withFunParamFunction "${actionParams1}_${actionParams2}"
        }

    }


}