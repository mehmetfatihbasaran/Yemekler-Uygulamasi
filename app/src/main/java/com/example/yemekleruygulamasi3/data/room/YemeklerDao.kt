package com.example.yemekleruygulamasi3.data.room

import androidx.room.Dao
import androidx.room.Query
import com.example.yemekleruygulamasi3.data.model.SqlYemekler

@Dao
interface YemeklerDao {

    @Query("SELECT * FROM yemekler")
    fun tumYemekleriAl(): List<SqlYemekler>

}