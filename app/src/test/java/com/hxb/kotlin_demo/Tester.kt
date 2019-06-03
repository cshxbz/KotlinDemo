package com.hxb.kotlin_demo

import org.junit.Test

class Tester {

    private val ms: MethodSample = MethodSample()
    private val nss: NullSafetySample = NullSafetySample()
    private val fs: FieldSample = FieldSample()

    @Test
    fun custom(){
        val name="aaa".also {
            println("also perform")
        }




    }

    @Test
    fun functionInvoke(){
        //传入lambda表达式作为参数
        ms.withFunParamFunction(i = 10, str = "bar", action = { i, str ->
            "$i-$str"
        })

        //最后一个参数是函数，传入lambda可以放在圆括号外
        ms.withFunParamFunction(i = 20, str = "foo") {i, str ->
            "$i-$str"
        }

        //传入匿名函数作为参数
        ms.withFunParamFunction(i = 30, str = "qux", action = fun(i: Int, str: String): String {
            return "$i-$str"
        })

        //函数的参数列表中只有一个函数,调用时可省略圆括号
        ms.onlySingleFunParamFunction { num1, num2 ->
            num1 * num2
        }

        //
        val result = ms.withReceiverLambda(5, 4)
        println(result)

    }


    @Test
    fun nullSafety() {
//        nss.safetyInvoke()
//        nss.noneSafetyInvoke()
//        nss.elvis()
        nss.safetyTypeConvert()
    }


    @Test
    fun classInitTest(){
        ClassInitSample(1, "k", true)

    }


    @Test
    fun overrideTest(){
        val d = D()
        d.f()
    }


    @Test
    fun fieldTest(){
        fs.propertyA=10
        println(fs.propertyA)

        fs.propertyD="init completed"
        println(fs.propertyD)

    }


    @Test
    fun collectionTest(){
        val readOnlyList = listOf("a", "b", "c")
        val mutableList = mutableListOf("d", "e", "f")

        mutableList.add("x")

    }


    @Test
    fun innerClassTest(){
        val nested: InnerClassSample.Nested = InnerClassSample.Nested()

    }


}