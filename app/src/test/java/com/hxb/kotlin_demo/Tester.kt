package com.hxb.kotlin_demo

import com.hxb.kotlin_demo.bean.Person
import org.junit.Test

class Tester {

    private val ms: MethodSample = MethodSample()
    private val nss: NullSafetySample = NullSafetySample()
    private val fs: FieldSample = FieldSample()

    @Test
    fun custom(){
        DestructuringSample().test()

    }

    @Test
    fun functionInvoke(){
        //传入lambda表达式作为参数
        ms.withFunParamFunction(i = 10, str = "receiverPersonObj", action = { i, str ->
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
    fun collection(){
        val readOnlyList = listOf("a", "b", "c")
        val mutableList = mutableListOf("d", "e", "f")

        mutableList.add("x")

    }


    @Test
    fun innerClass(){
        val nested: InnerClassSample.Nested = InnerClassSample.Nested()
    }


    @Test
    fun objectExpressionTest(){
        val oes = ObjectExpressionSample()

        /**
         * 传递一个匿名内部类对象作为参数
         */
        oes.receiverPersonObj(object : Person("Panzer"){
            override fun walk() {
                println("$name ex walk")
            }

            override fun eat() {
                println("$name ex eat")
            }
        })
    }


    @Test
    fun objectDeclare(){
        CustomObject.functionA()
    }


    @Test
    fun delegation() {
        val subPart = SubPartA()

        val mainPart = MainPart(subPart)
        mainPart.f1()
        mainPart.f2()
        println(mainPart.p1)

        subPart.f1()

    }


}