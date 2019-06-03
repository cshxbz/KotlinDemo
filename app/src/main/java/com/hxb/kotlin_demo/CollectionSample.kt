package com.hxb.kotlin_demo

class CollectionSample{


    /**
     * 集合分为read-only的和mutable的
     */
    fun collectionAccessTest(){
        val readOnlyList = listOf("a", "b", "c")
        readOnlyList[0]

        val mutableList= mutableListOf("a", "b", "c")
        mutableList.add("x")

    }


}