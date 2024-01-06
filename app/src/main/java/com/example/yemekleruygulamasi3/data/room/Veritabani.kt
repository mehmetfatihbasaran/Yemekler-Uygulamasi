package com.example.yemekleruygulamasi3.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yemekleruygulamasi3.data.model.SqlYemekler

@Database(entities = [SqlYemekler::class], version = 1)
abstract class Veritabani : RoomDatabase() {

    abstract fun yemeklerDao(): YemeklerDao

    companion object {
        private var INSTANCE: Veritabani? = null

        fun veritabaniOlustur(context: Context): Veritabani? {
            if (INSTANCE == null) {
                synchronized(Veritabani::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Veritabani::class.java,
                        "yemekler.sqlite"
                    ).createFromAsset("yemekler.sqlite")
                        .build()
                }
            }
            return INSTANCE
        }
    }

}