package com.study.navigation2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    /**
     * 隐藏菜单栏
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

}