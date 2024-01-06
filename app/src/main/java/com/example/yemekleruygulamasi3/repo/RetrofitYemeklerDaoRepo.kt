package com.example.yemekleruygulamasi3.repo

import androidx.lifecycle.MutableLiveData
import com.example.yemekleruygulamasi3.data.model.RetrofitCevap
import com.example.yemekleruygulamasi3.data.model.RetrofitYemekler
import com.example.yemekleruygulamasi3.data.retrofit.AppUtils
import com.example.yemekleruygulamasi3.data.retrofit.RetrofitYemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitYemeklerDaoRepo {

    var retrofitYemeklerListesi = MutableLiveData<List<RetrofitYemekler>>()
    var retrofitYemeklerDaoInterface: RetrofitYemeklerDaoInterface

    init {
        retrofitYemeklerDaoInterface = AppUtils.getRetrofitYemeklerDaoInterface()
        retrofitYemeklerListesi = MutableLiveData()
    }

    fun retrofitYemekleriGetir(): MutableLiveData<List<RetrofitYemekler>> {
        return retrofitYemeklerListesi
    }

    fun retrofitYemekleriAl() {
        retrofitYemeklerDaoInterface.tumYemekler().enqueue(object : Callback<RetrofitCevap> {
            override fun onResponse(call: Call<RetrofitCevap>, response: Response<RetrofitCevap>) {
                val liste = response.body()!!.yemekler
                retrofitYemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<RetrofitCevap>, t: Throwable) {
            }
        })
    }

}