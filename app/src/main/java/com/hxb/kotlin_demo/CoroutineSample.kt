package com.hxb.kotlin_demo

import kotlinx.coroutines.*

class CoroutineSample {

    companion object {
        fun test() {
            asyncTest()
        }

        private suspend fun execWork1(): String {
            var result: String
            withContext(Dispatchers.IO) {
                println("work1 start ! ${getThreadName()}")
                delay(3000L)
//                Thread.sleep(3000L)
                println("work1 finish ! ${getThreadName()}")
                result = "apple"
            }
            println("execWork1 out finish ${getThreadName()}")
            return result
        }

        private fun getThreadName(): String {
            return Thread.currentThread().name
        }


        private fun asyncTest() {
            GlobalScope.launch(Dispatchers.Default) {

                val async1 = async(Dispatchers.IO) {
                    var lastIndex = 0
                    repeat(10) {
                        delay(200)
                        println("async1:${it}")
                        lastIndex = it
                    }
                    lastIndex
                }

                val async2 = async(Dispatchers.IO) {
                    var lastIndex = 0
                    repeat(8) {
                        delay(300)
                        println("async2:${it}")
                        lastIndex = it
                    }
                    lastIndex
                }


                println("start wait")
                val result1 = async1.await()
                println("async1 end----------------${result1}")
                val result2 = async2.await()
                println("async2 end----------------${result2}")

            }

        }



    }

}