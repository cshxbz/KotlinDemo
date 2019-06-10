package com.hxb.kotlin_demo

class CompanionObjSample{

    companion object {
        var propertyA: Int = 20
        var propertyB: String = "vvv"

        init {
            println("CompanionObjSample companion object init")
        }

        fun foo() {
            println("CompanionObjSample companion object foo()")
        }
   }



}