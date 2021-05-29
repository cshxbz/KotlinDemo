package com.hxb.kotlin_demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.hxb.kotlin_demo.databinding.ActivityMainBinding
import com.hxb.kotlin_demo.launchCoroutines
import com.hxb.kotlin_demo.utils.printlnLog
import kotlinx.coroutines.*
import java.lang.IndexOutOfBoundsException
import java.lang.NullPointerException
import java.net.SocketException
import java.util.concurrent.TimeoutException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        binding.btnClick.setOnClickListener {


            launchCoroutines(
                block = {
                    printlnLog("outer: ${Thread.currentThread().name}")

                    GlobalScope.launch(Dispatchers.IO) {
                        delay(2000)
                        printlnLog("inner: ${Thread.currentThread().name}")
                    }

//                    withContext(Dispatchers.IO) {
//                        delay(3000)
//                    }


                    printlnLog("outer: end")

                },

                onError = {
                    printlnLog("onError")

                },

                onComplete = {
                    printlnLog("onComplete")
//                    throw IndexOutOfBoundsException()
                }

            )


        }


    }
}
