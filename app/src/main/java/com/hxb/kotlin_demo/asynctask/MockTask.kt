package com.hxb.kotlin_demo.asynctask

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


private val handler by lazy {
    Handler(Looper.getMainLooper())
}

fun mockRequest(requestName: String, params: String, callback: TaskCallback) {
    Thread {
        Thread.sleep(1000)
        handler.post {
            val success = true
            if (success) {
                callback.onSuccess(
                    data = "this is $requestName success result",
                    msg = "$requestName success"
                )
            } else {
                callback.onFail(msg = "$requestName fail")
            }
        }

    }.start()
}


/**
 * 将基于回调的异步调用包装成挂起方法的形式
 */
suspend fun mockRequestWrapCallback(requestName: String, params: String): TaskResult {
    return withContext(Dispatchers.IO) {
        return@withContext suspendCoroutine {

            mockRequest(requestName,params, object : TaskCallback {
                override fun onSuccess(data: String, msg: String) {
                    it.resume(
                        TaskResult.Success(
                            data = "this is $requestName success result",
                            msg = "$requestName success"
                        )
                    )
                }

                override fun onFail(msg: String) {
                    it.resume(TaskResult.Fail(msg = "$requestName fail"))
                }
            })
        }


    }

}



suspend fun mockRequestEx(requestName: String, params: String): TaskResult {
    return withContext(Dispatchers.IO) {
        Thread.sleep(1000)
        val success = true
        if (success) {
            TaskResult.Success(data = "this is $requestName success result", msg = "$requestName success")
        } else {
            TaskResult.Fail(msg = "$requestName fail")
        }
    }
}

suspend fun mockSaveDataToLocalEx(data: String): TaskResult {
    return withContext(Dispatchers.IO) {
        TaskResult.Success("", "")
    }
}


fun mockSaveDataToLocal(callback: TaskCallback) {

}


fun showLoading(){
    println("mock showLoading")
}

fun dismissLoading() {
    println("mock dismissLoading")
}


interface TaskCallback {
    fun onSuccess(data: String, msg: String)
    fun onFail(msg: String)
}


sealed class TaskResult(val msg: String){
    class Success(val data: String, msg: String) : TaskResult(msg)
    class Fail(msg: String) : TaskResult(msg)
}

