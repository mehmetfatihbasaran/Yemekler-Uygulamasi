package com.example.yemekleruygulamasi3.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RetrofitCevap(
    @SerializedName("yemekler")
    @Expose
    var yemekler: List<RetrofitYemekler>,
    @SerializedName("success")
    @Expose
    var success: Int
)
