package com.zerodev.bmandroidtest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zerodev.bmandroidtest.model.AppModel

@Dao
interface AppDao {

    @Query("SELECT * FROM appmodel")
    fun getData(): LiveData<List<AppModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(appModel: AppModel)

    @Query("DELETE FROM appmodel")
    suspend fun deleteAll()
}