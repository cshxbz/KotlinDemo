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


    /**
     * 简单创建集合的方式
     */
    fun commonCreationWay() {
        /*
         * 创建空集合
         */
        val emptyList = listOf<String>()
        val emptyMutableList = mutableListOf<String>()

        val emptyMap = mapOf<String, Int>()
        val emptyMutableMap = mutableMapOf<String, Int>()

        val emptySet = setOf<String>()
        val mutableEmptySet= mutableSetOf<String>()


        /*
         * 在创建的同时添加元素
         */
        val list = listOf(1, 2, 3)
        val map = mapOf("key1" to 1, "key1" to 2, "key1" to 3)
        val set = setOf("a", "b", "c")

    }


    /**
     * 通过传入初始化器来创建集合
     */
    fun createWithInitializer () {
        val list = List(5) { index: Int -> index * 2}
    }

}