package com.study.livedata2

import android.app.Application

class MyApplication : Application() {


    fun getInstance():Application {
        return this;
    }
}