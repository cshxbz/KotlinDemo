package com.hxb.kotlin_demo

class NullSafetySample {

    /**
     * 安全的调用
     */
    public fun safetyInvoke(){
        var sb: StringBuilder? = null
        println(sb?.append("a"))

        /*
         * let操作符:如果sb为空,打印语句则不会执行
         * 可配合 ?. 来使用
         */
        sb?.let {
            println(it)
        }
    }


    /**
     * 非安全的调用（会引起NPE）
     */
    public fun noneSafetyInvoke(){
        val sb: StringBuilder? = null
        println(sb!!.append("b"))
    }


    /**
     * 普通的 . 调用
     * 必须是不可空的类型才能这样调用
     */
    public fun plainInvoke(){
        val num: Int = 10
        num.plus(2)
    }


    /**
     * elvis操作符
     */
    public fun elvis(){

    }

}