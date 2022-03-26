package com.study.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavArgs
import androidx.navigation.Navigation


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflater = inflater.inflate(R.layout.fragment_home, container, false)

        inflater.findViewById<Button>(R.id.button).setOnClickListener{
            // 跳转到DetailFragment
            val navController = Navigation.findNavController(it)

            // 1. 普通传参 类型不安全
            val bundle=Bundle()
            bundle.putString("user_name","jack")
             


            navController.navigate(R.id.action_homeFragment_to_detailFragment,bundle)

        }
        return inflater
    }




}