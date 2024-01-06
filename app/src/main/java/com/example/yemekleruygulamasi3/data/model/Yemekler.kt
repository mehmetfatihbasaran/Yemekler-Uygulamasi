package com.example.yemekleruygulamasi3.data.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Yemekler(
    var yemek_id: String? = "",
    val yemek_adi: String? = "",
    val yemek_resim_adi: String? = "",
    val yemek_fiyat: String? = ""
)
