package com.mityushovn.kodetestproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mityushovn.kodetestproject.ui.theme.KodetestprojectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KodetestprojectTheme {

            }
        }
    }
}
