package com.study.navigation3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    /**
     * 支持返回按钮
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        return navController.navigateUp()
    }
}