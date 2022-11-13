package com.akardas.coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akardas.coroutine.networking.ApiHelper
import com.akardas.coroutine.networking.MainRepository
import com.akardas.coroutine.viewModels.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(MainRepository(apiHelper)) as T
    }

}