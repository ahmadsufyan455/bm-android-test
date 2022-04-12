package com.zerodev.bmandroidtest.repository

import androidx.lifecycle.LiveData
import com.zerodev.bmandroidtest.model.AppModel

class AppRepository(private val appDataSource: AppDataSource) {
    fun getData(): LiveData<List<AppModel>> {
        return appDataSource.getData()
    }

    suspend fun insertData(appModel: AppModel) {
        appDataSource.insertData(appModel)
    }

    suspend fun deleteAll() {
        appDataSource.deleteAll()
    }
}