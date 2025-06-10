package com.example.shared_preferences.pref_database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(val userPref: userPref) : ViewModel() {
    val username = userPref.getName().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ""
    )

    fun saveData(name: String) {
        viewModelScope.launch {
            userPref.saveName(name)
        }

    }
}