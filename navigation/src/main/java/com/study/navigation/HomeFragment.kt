package com.study.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
            navController.navigate(R.id.action_homeFragment_to_detailFragment)
        }
        return inflater
    }




}