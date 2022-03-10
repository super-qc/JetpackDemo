package com.study.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleService

/**
 * 使用LifecycleService 与 DefaultLifecycleObserver 对service与组件进行解耦
 */
class MyLocationService : LifecycleService() {
    init{
        Log.d(TagUtil.tagName, "MyLocationService init")
        lifecycle.addObserver(MyLocationObserver(this))
    }
}