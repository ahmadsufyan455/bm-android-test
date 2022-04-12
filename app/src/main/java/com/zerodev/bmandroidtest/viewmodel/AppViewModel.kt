package com.zerodev.bmandroidtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zerodev.bmandroidtest.model.AppModel
import com.zerodev.bmandroidtest.network.ApiClient
import com.zerodev.bmandroidtest.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(private val appRepository: AppRepository) : ViewModel() {
    private val listData = MutableLiveData<List<AppModel>>()

    fun setData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = ApiClient.instance.getData()
            if (response.isSuccessful) {
                listData.postValue(response.body()?.may)
                listData.postValue(response.body()?.jun)
            }
        }
    }

    fun getData(): LiveData<List<AppModel>> = listData

    fun getDataFromDb(): LiveData<List<AppModel>> {
        return appRepository.getData()
    }

    fun insertData(appModel: AppModel) {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.insertData(appModel)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.deleteAll()
        }
    }
}