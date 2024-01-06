package com.example.yemekleruygulamasi3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.yemekleruygulamasi3.nav.SayfaGecisleri
import com.example.yemekleruygulamasi3.ui.theme.YemeklerUygulamasi3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YemeklerUygulamasi3Theme {
                SayfaGecisleri()
            }
        }
    }
}

