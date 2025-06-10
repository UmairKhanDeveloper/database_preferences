package com.example.shared_preferences

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shared_preferences.pref_database.MainScreen
import com.example.shared_preferences.ui.theme.Shared_preferencesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Shared_preferencesTheme {
                MainScreen()
            }
        }
    }
}
