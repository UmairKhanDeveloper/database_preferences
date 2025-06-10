package com.example.shared_preferences.pref_database

import kotlinx.coroutines.flow.Flow

interface userPref {
    fun getName(): Flow<String>

    suspend fun saveName(name: String)



}