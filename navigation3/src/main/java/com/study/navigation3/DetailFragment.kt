package com.study.navigation3

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
        Log.d("navigation3", "DetailFragment name:${arguments?.getString("name")}")


        Log.d("navigation3", "DetailFragment params:${arguments?.getString("params")}")
        inflater.findViewById<Button>(R.id.button2).setOnClickListener {
            // 跳转到DetailFragment
            Navigation.findNavController(it).navigate(R.id.action_detailFragment_to_homeFragment)
        }
        return inflater
    }

}