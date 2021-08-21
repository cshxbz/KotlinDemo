package com.hxb.kotlin_demo

import kotlinx.coroutines.*

fun launchCoroutines(
    block: suspend CoroutineScope.() -> Unit,
    onError: (e: Throwable) -> Unit = {},
    onComplete: suspend () -> Unit = {}
): Job {

    val coroutineExceptionHandler = CoroutineExceptionHandler { _, e ->
        onError(e)
        e.printStackTrace()
    }

    return GlobalScope.launch(coroutineExceptionHandler) {
        block.invoke(this)
//        try {
//            block.invoke(this)
//        } finally {
//            onComplete()
//        }
    }

}