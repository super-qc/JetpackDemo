package com.study.lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.util.Log
import android.widget.Chronometer
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver


class MyChronometer constructor(context: Context, attributeSet: AttributeSet) :
    Chronometer(context, attributeSet), DefaultLifecycleObserver {

    private var elapsedTime:Long=0L

    @Override
    fun onResume() {
        base = SystemClock.elapsedRealtime() - elapsedTime
        start();
        Log.d("JetPackDemo","MyChronometer onResume")
    }
    @Override
    fun onPause() {
        elapsedTime = SystemClock.elapsedRealtime() - base
        stop()
        Log.d("JetPackDemo","MyChronometer onStop")
    }

}