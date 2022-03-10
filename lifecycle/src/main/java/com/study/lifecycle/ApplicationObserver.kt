package com.study.lifecycle

import android.util.Log
import androidx.lifecycle.*

class ApplicationObserver:DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d(TagUtil.tagName,"ApplicationObserver onCreate()..")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TagUtil.tagName,"ApplicationObserver onStart()..")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(TagUtil.tagName,"ApplicationObserver onResume()..")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TagUtil.tagName,"ApplicationObserver onPause()..")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d(TagUtil.tagName,"ApplicationObserver onStop()..")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TagUtil.tagName,"ApplicationObserver onDestroy()..")
    }
}