package com.study.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import com.study.lifecycle.databinding.ActivityMainBinding

/**
 *
 * 使用lifecycle解耦页面与组件
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        binding.chronometer.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.chronometer.onPause()
    }
}