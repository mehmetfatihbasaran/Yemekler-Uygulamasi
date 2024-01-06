package com.example.yemekleruygulamasi3.data.retrofit

class AppUtils {
    companion object {
        const val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getRetrofitYemeklerDaoInterface(): RetrofitYemeklerDaoInterface {
            return RetrofitClient.getClient(BASE_URL)
                .create(RetrofitYemeklerDaoInterface::class.java)
        }
    }
}