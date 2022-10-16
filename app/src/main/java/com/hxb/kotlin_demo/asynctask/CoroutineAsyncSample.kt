package com.hxb.kotlin_demo.asynctask

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutineAsyncSample {

    private fun perform1() {
        GlobalScope.launch(Dispatchers.Main) {
            showLoading()

            //请求接口1
            val req1Result = doRequest1(params = "request1_params")
            if (req1Result is TaskResult.Fail) {
                dismissLoading()
                return@launch
            }

            val req1Data = (req1Result as TaskResult.Success).data

            //请求接口2
            val req2Result = doRequest2(params = req1Data)
            if (req2Result is TaskResult.Fail) {
                dismissLoading()
                return@launch
            }

            val req2Data = (req2Result as TaskResult.Success).data

            //请求接口4
            val req4Result = doRequest4(params = req2Data)
            if (req4Result is TaskResult.Fail) {
                dismissLoading()
                return@launch
            }

            val req4Data = (req4Result as TaskResult.Success).data

            //保存数据到本地
            val saveLocalResult = doSaveLocal(req4Data)
            when (saveLocalResult) {
                is TaskResult.Success -> {
                    println("流程结束")
                }
                is TaskResult.Fail -> {
                    println("保存数据失败")
                }
            }
            dismissLoading()
        }
    }


    private fun perform2() {


    }


    private suspend fun doRequest1(params: String): TaskResult {
        return mockRequestEx(requestName = "request_1", params = params)
    }

    private suspend fun doRequest2(params: String): TaskResult {
        return mockRequestEx(requestName = "request_2", params = params)
    }

    private suspend fun doRequest3(params: String): TaskResult {
        return mockRequestEx(requestName = "request_3", params = params)
    }

    private suspend fun doRequest4(params: String): TaskResult {
        return mockRequestEx(requestName = "request_4", params = params)
    }

    private suspend fun doSaveLocal(data: String): TaskResult {
        return mockSaveDataToLocalEx(data)
    }

}