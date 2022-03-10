package com.study.livedata2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MyViewModel : ViewModel() {
    private var process: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        process.value = 0
    }

    fun getProcess(): MutableLiveData<Int> {
        return process
    }

}