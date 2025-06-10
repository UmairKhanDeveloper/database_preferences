package com.example.shared_preferences.pref

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val dataStore: DataStore<Preferences> = remember {
        androidx.datastore.preferences.preferencesDataStore(name = "user_prefs")
            .getValue(context, context::javaClass)
    }

    val userPref = remember { UserPrefImpl(dataStore) }

    val viewModel = remember { MainViewModel(userPref) }
    val userName = viewModel.username.collectAsState()
    var textField by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "your save name : ${userName.value}",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = textField, onValueChange = {
            textField = it
        })

        Spacer(modifier = Modifier.height(2.dp))
        Button(onClick = {
            viewModel.saveData(textField)
        }) {
            Text(text = "save button")
        }

    }

}