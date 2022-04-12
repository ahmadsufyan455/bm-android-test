package com.zerodev.bmandroidtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zerodev.bmandroidtest.model.AppModel

@Database(entities = [AppModel::class], version = 1)
abstract class AppModelDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}