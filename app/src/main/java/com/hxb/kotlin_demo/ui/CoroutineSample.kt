package com.hxb.kotlin_demo.ui

import kotlinx.coroutines.*

class CoroutineSample {

    companion object {
        fun test() {
            GlobalScope.launch(Dispatchers.Main) {
                println("start ! ${getThreadName()}")
                execWork1()
                println("end ! ${getThreadName()}")
            }
        }

        private suspend fun execWork1() {
            withContext(Dispatchers.IO) {
                println("work1 start ! ${getThreadName()}")
                delay(3000L)
                println("work1 finish ! ${getThreadName()}")
            }
            println("execWork1 out finish ${getThreadName()}")
        }

        private fun getThreadName(): String {
            return "current thread name: ${Thread.currentThread().name}"
        }

    }

}