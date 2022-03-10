package com.study.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MyViewModel : ViewModel() {
    private var currentSecond: MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        currentSecond.value = 0
    }

    fun getCurrentSecond(): MutableLiveData<Int> {
        return currentSecond
    }

}