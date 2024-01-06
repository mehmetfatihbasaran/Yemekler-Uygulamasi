package com.example.yemekleruygulamasi3.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.yemekleruygulamasi3.data.model.RetrofitYemekler
import com.example.yemekleruygulamasi3.data.model.SqlYemekler
import com.example.yemekleruygulamasi3.data.model.Yemekler
import com.example.yemekleruygulamasi3.repo.RetrofitYemeklerDaoRepo
import com.example.yemekleruygulamasi3.repo.SqlYemeklerDaoRepo
import com.example.yemekleruygulamasi3.repo.YemeklerDaoRepository

class AnaSayfaViewModel(application: Application): AndroidViewModel(application) {

    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var yemeklerRepo = YemeklerDaoRepository()
    var sqlRepository = SqlYemeklerDaoRepo(application)
    var sqlYemeklerListesi = MutableLiveData<List<SqlYemekler>>()

    var retrofitRepo = RetrofitYemeklerDaoRepo()
    var retrofitListesi = MutableLiveData<List<RetrofitYemekler>>()

    init {
        yemekleriAl()
        sqlYemekleriAl()
        retrofitYemekleriAl()
        yemeklerListesi = yemeklerRepo.yemekleriGetir()
        sqlYemeklerListesi = sqlRepository.sqlYemekleriGetir()
        retrofitListesi = retrofitRepo.retrofitYemekleriGetir()
    }

    fun yemekleriAl(){
        yemeklerRepo.tumYemekeriAl()
    }

    fun sqlYemekleriAl(){
        sqlRepository.sqlYemekleriAl()
    }

    fun retrofitYemekleriAl(){
        retrofitRepo.retrofitYemekleriAl()
    }

}