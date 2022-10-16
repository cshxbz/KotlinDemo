package com.hxb.kotlin_demo

import com.hxb.kotlin_demo.extensions.getClassName

class MainClass {

    companion object{
        @JvmStatic
        fun main(args:Array<String>){
            val str = String()
            val clazzSimpleName = str.getClassName()
            println(clazzSimpleName)

        }

    }

}