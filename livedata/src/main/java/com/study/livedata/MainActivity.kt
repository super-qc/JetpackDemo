package com.study.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)
        viewModel = ViewModelProvider(
            this, ViewModelProvider
                .AndroidViewModelFactory(application)
        ).get(MyViewModel::class.java)
        tv.text=viewModel.getCurrentSecond().toString()

        viewModel.getCurrentSecond().observe(this,object:Observer<Int>{
            override fun onChanged(t: Int?) {
                tv.text=t.toString()
            }

        })
        startTimer();
    }

    private fun startTimer(){
        Timer().schedule(object:TimerTask()
        {
            override fun run() {
                // 非UI线程使用postValue
                // UI线程 setValue
                viewModel.getCurrentSecond().postValue(viewModel.getCurrentSecond().value?.plus(1))
            }

        }
        ,1000,1000)
    }
}