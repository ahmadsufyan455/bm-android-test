package com.zerodev.bmandroidtest.repository

import androidx.lifecycle.LiveData
import com.zerodev.bmandroidtest.database.AppDao
import com.zerodev.bmandroidtest.model.AppModel

class AppDataSource(private val appDao: AppDao) {
    fun getData(): LiveData<List<AppModel>> = appDao.getData()
    suspend fun insertData(appModel: AppModel) = appDao.insert(appModel)
    suspend fun deleteAll() = appDao.deleteAll()
}