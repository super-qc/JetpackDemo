package com.study.databinding3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val aTeamScore: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }
    val bTeamScore: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }
    var lastATeamScore = 0
    var lastBTeamScore = 0


    fun aTeamAdd(i: Int) {
        //aTeamScore.value = aTeamScore.value?.plus(1)
        saveLastScore()
        aTeamScore.value = aTeamScore.value?.plus(i)
    }

    fun bTeamAdd(i: Int) {
        //bTeamScore.value = bTeamScore.value?.plus(1)
        saveLastScore()
        bTeamScore.value = bTeamScore.value?.plus(i)
    }

    fun undo() {
        aTeamScore.value = lastATeamScore
        bTeamScore.value = lastBTeamScore
    }

    fun saveLastScore() {
        aTeamScore.value?.let {
            lastATeamScore = it
        }
        bTeamScore.value?.let {
            lastBTeamScore = it
        }
    }

    fun reset() {
        aTeamScore.value = 0
        bTeamScore.value = 0
    }

}