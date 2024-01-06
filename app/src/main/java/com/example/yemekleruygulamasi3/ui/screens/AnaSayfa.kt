package com.example.yemekleruygulamasi3.ui.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.yemekleruygulamasi3.R
import com.example.yemekleruygulamasi3.view_model.AnaSayfaFactory
import com.example.yemekleruygulamasi3.view_model.AnaSayfaViewModel
import com.google.gson.Gson

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("DiscouragedApi")
@Composable
fun AnaSayfa(navController: NavController) {

    val viewModel: AnaSayfaViewModel = viewModel(
        factory = AnaSayfaFactory(LocalContext.current.applicationContext as Application)
    )
    val yemeklerListesi = viewModel.yemeklerListesi.observeAsState(initial = listOf())
    val sqlYemeklerListesi = viewModel.sqlYemeklerListesi.observeAsState(initial = listOf())
    val retrofitYemeklerListesi = viewModel.retrofitListesi.observeAsState(initial = listOf())

    /*
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { androidx.compose.material3.Text(text = "Yemekler") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.anaRenk),
                    titleContentColor = colorResource(id = R.color.white),
                )
            )
        },
        content = { paddingValues ->
            LazyColumn (modifier = Modifier.padding(paddingValues)
            ) {
                items(
                    count = retrofitYemeklerListesi.value!!.count(),
                    itemContent = {
                        val yemek = retrofitYemeklerListesi.value!![it]
                        androidx.compose.material3.Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.clickable {
                                val yemekJson = Gson().toJson(yemek)
                                navController.navigate("detay_sayfa/$yemekJson")
                            }) {
                                Row(
                                    verticalAlignment = CenterVertically,
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth()
                                ) {
                                    GlideImage(
                                        imageModel = { "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}" },
                                        modifier = Modifier.size(100.dp)
                                    )
                                    Row(
                                        verticalAlignment = CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Text(text = yemek.yemek_adi, fontSize = 20.sp)
                                            Spacer(modifier = Modifier.size(30.dp))
                                            androidx.compose.material3.Text(
                                                text = "${yemek.yemek_fiyat} ₺",
                                                color = Color.Blue
                                            )
                                        }
                                        androidx.compose.material3.Icon(
                                            painter = painterResource(id = R.drawable.arrow_right),
                                            contentDescription = ""
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    )

     */


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Ana Sayfa") },
                backgroundColor = colorResource(id = R.color.anaRenk),
                contentColor = colorResource(id = R.color.koyuRenk)
            )
        },
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(retrofitYemeklerListesi.value) { yemek ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.clickable {
                        val yemekJson = Gson().toJson(yemek)
                        navController.navigate("detaySayfa/$yemekJson")
                    }
                    ) {
                        Row(
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                        ) {

                            GlideImage(
                                model = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.yemek_resim_adi,
                                contentDescription = "${yemek.yemek_adi} Resmi",
                                modifier = Modifier.size(100.dp)
                            )

                            /*

                            val activity = LocalContext.current as Activity
                            Image(
                                bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(
                                        yemek.yemek_resim_adi, "drawable", activity.packageName
                                    )
                                ),
                                contentDescription = "${yemek.yemek_adi} Resmi",
                                modifier = Modifier.size(100.dp)
                            )
                            */

                            Row(
                                verticalAlignment = CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxHeight()
                                ) {
                                    Text(text = yemek.yemek_adi, fontSize = 20.sp)
                                    Spacer(modifier = Modifier.height(25.dp))
                                    Text(
                                        text = yemek.yemek_fiyat.toString() + " ₺",
                                        fontSize = 20.sp
                                    )
                                }
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_right),
                                    contentDescription = "Göster"
                                )
                            }
                        }
                    }

                }
            }
        }
    }

}