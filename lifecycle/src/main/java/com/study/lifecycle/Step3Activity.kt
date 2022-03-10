package com.study.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.study.lifecycle.databinding.ActivityMainBinding
import com.study.lifecycle.databinding.ActivityStep3Binding

/**
 * 使用LifecycleService 与 DefaultLifecycleObserver 对service与组件进行解耦
 */
class Step3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityStep3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStep3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startGps()
        }
        binding.btnEnd.setOnClickListener {
            stopGps()
        }
    }

    private fun startGps() {
        Log.d(TagUtil.tagName,"Step3Activity startGps")
        startService(Intent(this, MyLocationService::class.java))
    }

    private fun stopGps() {
        stopService(Intent(this, MyLocationService::class.java))
    }

}