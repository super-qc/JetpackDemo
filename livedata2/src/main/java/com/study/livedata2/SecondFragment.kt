package com.study.livedata2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class SecondFragment : Fragment() {
    private lateinit var seekBar: SeekBar
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val mInflater = inflater.inflate(R.layout.fragment_second, container, false)
        seekBar = mInflater.findViewById(R.id.seekBar)

        viewModel = ViewModelProvider(
            requireActivity(), ViewModelProvider
                .AndroidViewModelFactory(MyApplication().getInstance())
        ).get(MyViewModel::class.java)

        viewModel.getProcess().observe(requireActivity()) { t: Int ->
            Log.d("LiveData2", "SecondFragment viewModel onChanged t:${t}")
            seekBar.setProgress(t)

        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.getProcess().value = progress
                Log.d(
                    "LiveData2",
                    "SecondFragment seekBar onProgressChanged viewModel.getProcess().value:${viewModel.getProcess().value}"
                )
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        return mInflater

    }

}