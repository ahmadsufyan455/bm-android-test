package com.zerodev.bmandroidtest.di

import androidx.room.Room
import com.zerodev.bmandroidtest.database.AppModelDatabase
import com.zerodev.bmandroidtest.repository.AppDataSource
import com.zerodev.bmandroidtest.repository.AppRepository
import com.zerodev.bmandroidtest.viewmodel.AppViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    factory { get<AppModelDatabase>().appDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppModelDatabase::class.java, "app.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val repositoryModule = module {
    single { AppDataSource(get()) }
    single { AppRepository(get()) }
}

val viewModelModule = module {
    viewModel { AppViewModel(get()) }
}