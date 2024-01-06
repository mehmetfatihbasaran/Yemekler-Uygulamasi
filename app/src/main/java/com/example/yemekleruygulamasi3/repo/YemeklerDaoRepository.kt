package com.example.yemekleruygulamasi3.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.yemekleruygulamasi3.data.model.Yemekler
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class YemeklerDaoRepository {

    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var refYemekler: DatabaseReference

    init {
        yemeklerListesi = MutableLiveData()
        val db = FirebaseDatabase.getInstance()
        refYemekler = db.getReference("Yemekler")
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }



    fun tumYemekeriAl() {
        refYemekler.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val liste = ArrayList<Yemekler>()
                for (ds in snapshot.children) {
                    val yemek = ds.getValue(Yemekler::class.java)
                    if (yemek != null) {
                        yemek.yemek_id = ds.key
                        liste.add(yemek)
                    }
                    liste.add(yemek!!)
                }
                yemeklerListesi.value = liste
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

}