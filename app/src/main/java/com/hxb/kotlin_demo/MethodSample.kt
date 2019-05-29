package com.hxb.kotlin_demo

class MethodSample {

    /**
     * lambda表达式中只有一个参数，该参数隐式生命维it
     */
    public val onlyOneParamLambda: (String) -> Int = {
        it.length
    }

    /**
     * 带有接收者的lambda
     */
    public val withReceiverLambda: Int.(Int)-> Int= {
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
    public fun withFunParamFunction(i: Int, str: String, action: (i: Int, str: String) -> String): String {
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


}