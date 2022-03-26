package com.example.databinding2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        //activityMainBinding.networkImage = "http://resources.jsmo.xin/templates/upload/1004/201703/1490249868350.jpg"
        activityMainBinding.networkImage=""
        activityMainBinding.localImage=R.mipmap.xinyuanjieyi

    }
}