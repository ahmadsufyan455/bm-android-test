package com.zerodev.bmandroidtest.network

import com.zerodev.bmandroidtest.model.AppDateModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("web/test_programmer.php")
    suspend fun getData(): Response<AppDateModel>
}