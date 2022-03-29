package com.study.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflater = inflater.inflate(R.layout.fragment_detail, container, false)

        // 默认传参方式
        Log.d("navigation", "DetailFragment user_name:${arguments?.getString("user_name")}")

        // SafeArgs
        val homeFragmentArgs = arguments?.let { HomeFragmentArgs.fromBundle(it) }
        Log.d(
            "navigation",
            "DetailFragment SafeArgs user_name:${homeFragmentArgs?.userName},age:${homeFragmentArgs?.age}"
        )

        inflater.findViewById<Button>(R.id.button2).setOnClickListener {
            // 跳转到DetailFragment
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_detailFragment_to_homeFragment)
        }
        return inflater
    }

}