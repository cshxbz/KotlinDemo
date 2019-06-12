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


    /**
     * 集合的拷贝与转换
     * 集合的拷贝是浅拷贝，即只是拷贝集合对象本身，副本集合内的元素仍是引用源集合内的元素
     */
    fun copyAndConversion() {
        val source = listOf(1, 2, 3)
        val copyList = source.toMutableList()
        copyList.add(4)

        println(source===copyList)
        println("source size: ${source.size}  copy size: ${copyList.size}")

    }


    fun operationFilter() {
        val numbers = listOf("one", "two", "three", "four", "five")

        val filteredList = numbers.filter {
            it.length > 3
        }
        println(filteredList)
    }


    fun operationMap() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val mapped = numbers.map {
            "$it x"
        }
        println(mapped)
    }


    fun operationAssociation() {
        val numbers = listOf("one", "two", "three", "four", "five")
        val result = numbers.associateWith {
            it.length
        }
        println(result)
    }


    /**
     * 集合的遍历方式
     */
    fun traverseWay() {
        val numbers = listOf("one", "two", "three", "four")
        /*
         * 迭代器方式遍历
         */
        val numbersIterator = numbers.iterator()
        while (numbersIterator.hasNext()) {
            print("${numbersIterator.next()},")
        }
        println()


        /*
         * for循环遍历
         */
        for (item in numbers) {
            print("$item,")
        }
        println()

        /*
         * forEach函数遍历
         */
        numbers.forEach {
            print("$it,")
        }
        println()


        /*
         * 可变迭代器，可以在遍历过程中删除元素
         */
        val mutableNumbers = mutableListOf("one", "two", "three", "four")
        val mutableIterator = mutableNumbers.iterator()

        mutableIterator.next()
        mutableIterator.remove()
        println("After removal: $mutableNumbers")
    }

}