package com.study.navigation3

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavArgs
import androidx.navigation.Navigation


class HomeFragment : Fragment() {
    var notificationId = 1;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflater = inflater.inflate(R.layout.fragment_home, container, false)

        inflater.findViewById<Button>(R.id.button).setOnClickListener {
            // 跳转到DetailFragment
            val navController = Navigation.findNavController(it)
            sendNotification()


        }
        return inflater
    }

    private fun sendNotification() {

        // 通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                activity?.packageName,
                "MyChannel",
                NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationChannel.description = "My NotificationChannel"
            val notificationManager = activity?.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(notificationChannel)
        }
        val notification = activity?.let {
            NotificationCompat.Builder(it, it.packageName)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("Deep Link")
                .setContentText("点我试试。。")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getpendingIntent())
                .build()
        }

        val notificationManagerCompat = activity?.let { NotificationManagerCompat.from(it) }

        if (notification != null) {
            notificationManagerCompat?.notify(notificationId++, notification)
        }


    }

    private fun getpendingIntent(): PendingIntent? {
        val args = Bundle()
        args.putString("name","jack")
        return activity?.let { Navigation.findNavController(it, R.id.button) }
            ?.createDeepLink()
            ?.setGraph(R.navigation.my_nav_graph)
            ?.setDestination(R.id.detailFragment)
            ?.setArguments(args)
            ?.createPendingIntent()
    }

}