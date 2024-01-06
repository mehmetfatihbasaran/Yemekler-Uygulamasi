package com.example.yemekleruygulamasi3.data.retrofit

import com.example.yemekleruygulamasi3.data.model.RetrofitCevap
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitYemeklerDaoInterface {

    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler(): Call<RetrofitCevap>

}