package com.study.lifecycle

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.*

class MyLocationObserver(context: Context) : DefaultLifecycleObserver {
    private val mContext = context
    private var locationManager: LocationManager? = null
    private val locationListener: MyLocationListener = MyLocationListener()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        // 获取gps位置
        Log.d(TagUtil.tagName, "MyLocationListener 开始获取GPS位置")
        locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                mContext,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        locationManager?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            3000, 1f,
            locationListener
        )

    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d(TagUtil.tagName, "MyLocationListener 停止获取GPS位置")
        locationManager?.removeUpdates(locationListener)

    }

    open class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d(TagUtil.tagName, "MyLocationListener onLocationChanged 位置发生改变")
        }
    }


}