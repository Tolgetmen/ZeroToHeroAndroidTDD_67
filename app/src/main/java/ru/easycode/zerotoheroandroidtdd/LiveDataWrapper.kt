package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper : ProvideLiveData {
    fun update(value: UiState)


    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper {
        override fun liveData(): LiveData<UiState> {
            return liveData
        }

        override fun update(value: UiState) {
            liveData.value = value
        }
    }
}

interface ProvideLiveData {
    fun liveData(): LiveData<UiState>
}