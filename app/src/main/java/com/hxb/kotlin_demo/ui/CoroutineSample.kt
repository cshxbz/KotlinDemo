package com.hxb.kotlin_demo.ui

import kotlinx.coroutines.*

class CoroutineSample {

    companion object {
        fun test() {
            GlobalScope.launch(Dispatchers.Main) {
                println("start ! ${getThreadName()}")
                val work1Result = execWork1()
                println("end ! ${getThreadName()}--$work1Result")
            }
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

    }

}