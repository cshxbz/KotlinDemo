package com.hxb.kotlin_demo.asynctask


class PlainAsyncWaySample {


    fun perform1() {
        doRequest1(flag = 1)
    }

    fun perform2(){
        doRequest1(flag = 2)
    }


    private fun doRequest1(flag: Int) {
        mockRequest(requestName = "request_1", params = "request1_params", callback = object : TaskCallback {
            override fun onSuccess(data: String, msg: String) {
                when (flag) {
                    1 -> doRequest2(flag, data)
                    2 -> doRequest3(flag, data)
                }
            }

            override fun onFail(msg: String) {

            }

        })
    }


    private fun doRequest2(flag: Int,params:String) {
        mockRequest(requestName = "request_2", params = params, callback = object : TaskCallback {
            override fun onSuccess(data: String, msg: String) {
                doRequest4(flag, data)
            }

            override fun onFail(msg: String) {

            }

        })
    }


    private fun doRequest3(flag: Int, params: String) {
        mockRequest(requestName = "request_3", params = params, callback = object : TaskCallback {
            override fun onSuccess(data: String, msg: String) {
                doRequest4(flag, params)
            }

            override fun onFail(msg: String) {

            }

        })
    }


    private fun doRequest4(flag: Int, params: String) {
        mockRequest(requestName = "request_4", params = params, callback = object : TaskCallback {
            override fun onSuccess(data: String, msg: String) {
                if (flag == 1) {
                    doSaveLocal(data)
                } else {
                    println("流程结束")
                }
            }

            override fun onFail(msg: String) {

            }

        })
    }


    private fun doSaveLocal(data: String) {
        mockSaveDataToLocal(object : TaskCallback {
            override fun onSuccess(data: String, msg: String) {
                println("流程结束")
            }

            override fun onFail(msg: String) {
            }
        })
    }



}