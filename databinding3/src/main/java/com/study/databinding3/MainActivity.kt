package com.study.databinding3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.study.databinding3.databinding.ActivityMainBinding

/**
 * databinding - RecycleView绑定
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        // 添加生命周期感知
        activityMainBinding.lifecycleOwner = this
    }
}