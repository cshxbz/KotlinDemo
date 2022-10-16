package com.hxb.kotlin_demo.asynctask

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


private val handler by lazy {
    Handler(Looper.getMainLooper())
}

fun mockRequest(requestName: String, params: String, callback: TaskCallback) {
    Thread {
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

}

fun dismissLoading() {


}


interface TaskCallback {
    fun onSuccess(data: String, msg: String)
    fun onFail(msg: String)
}


sealed class TaskResult(val msg: String){
    class Success(val data: String, msg: String) : TaskResult(msg)
    class Fail(msg: String) : TaskResult(msg)
}

