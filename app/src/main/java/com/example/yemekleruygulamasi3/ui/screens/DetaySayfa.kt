package com.example.yemekleruygulamasi3.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.yemekleruygulamasi3.R
import com.example.yemekleruygulamasi3.data.model.Yemekler

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("DiscouragedApi")
@Composable
fun DetaySayfa(yemek: Yemekler) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { yemek.yemek_adi?.let { Text(text = it) } },
                backgroundColor = colorResource(id = R.color.anaRenk),
                contentColor = colorResource(id = R.color.white)
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = CenterHorizontally
        ) {

            GlideImage(
                model = "http://kasimadalan.pe.hu/yemekler/resimler/" + yemek.yemek_resim_adi,
                contentDescription = "${yemek.yemek_adi} Resmi",
                modifier = Modifier.size(250.dp)
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
                modifier = Modifier.size(250.dp)
            )
            */

            yemek.yemek_adi?.let { it1 -> Text(text = it1, fontSize = 50.sp) }
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = yemek.yemek_fiyat + " ₺", fontSize = 50.sp)
            Button(
                onClick = {

                },
                modifier = Modifier.size(250.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.anaRenk),
                    contentColor = colorResource(id = R.color.white)
                )
            ) {
                Text(text = "Sepete Ekle")
            }
        }
    }
}