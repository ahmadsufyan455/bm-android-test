package com.zerodev.bmandroidtest.model

import com.google.gson.annotations.SerializedName

data class AppDateModel(
    @SerializedName("2017-05")
    val may: List<AppModel>,
    @SerializedName("2017-06")
    val jun: List<AppModel>
    // so on....
)
