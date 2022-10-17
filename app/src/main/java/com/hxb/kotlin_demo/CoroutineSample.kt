package com.hxb.kotlin_demo

import kotlinx.coroutines.*

class CoroutineSample {

    companion object {
        fun test() {
            GlobalScope.launch(Dispatchers.Main) {

                val part1Result = withContext(Dispatchers.IO) {
                    Thread.sleep(2000)
                    return@withContext "part 1 result"
//                    return@withContext 100
                }

                val part2Result = withContext(Dispatchers.Default) {
                    Thread.sleep(2000)
                    return@withContext "part 2 result"
                }



            }
        }



        private suspend fun execWork1(): String {
            var result: String
            withContext(Dispatchers.IO) {
                println("work1 start ! ${getThreadName()}")
                delay(3000L)
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