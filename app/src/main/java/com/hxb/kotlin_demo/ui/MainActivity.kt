package com.hxb.kotlin_demo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hxb.kotlin_demo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * 导入 kotlinx.android.synthetic.main.＜布局＞.* 后，
         * 可以免去 findViewById, 可直接访问布局中的控件，使用控件的id来访问
         */
        btn_exec_work.setOnClickListener {
            CoroutineSample.test()
        }

        btn_click.setOnClickListener{
            Log.i("System.out","click btn !")
        }


    }
}
