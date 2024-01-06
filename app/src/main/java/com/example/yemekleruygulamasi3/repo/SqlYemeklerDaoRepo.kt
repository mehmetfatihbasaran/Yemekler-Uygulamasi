package com.example.yemekleruygulamasi3.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.yemekleruygulamasi3.data.model.SqlYemekler
import com.example.yemekleruygulamasi3.data.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SqlYemeklerDaoRepo(var application: Application) {

    private var sqlYemeklerListesi = MutableLiveData<List<SqlYemekler>>()
    private var vt: Veritabani

    init {
        vt = Veritabani.veritabaniOlustur(application)!!
        sqlYemeklerListesi = MutableLiveData()
    }

    fun sqlYemekleriGetir(): MutableLiveData<List<SqlYemekler>> {
        return sqlYemeklerListesi
    }

    fun sqlYemekleriAl() {
        CoroutineScope(Dispatchers.IO).launch {
            val yemekListesi = vt.yemeklerDao().tumYemekleriAl()
            withContext(Dispatchers.Main) {
                sqlYemeklerListesi.value = yemekListesi
            }
        }
    }


}