package com.example.shared_preferences.pref

import android.preference.PreferenceDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserPrefImpl(private val dataStore: DataStore<Preferences>) : userPref {
    companion object {
        private val USER_KEY = stringPreferencesKey("user_name")
    }

    override fun getName(): Flow<String> {
        return dataStore.data
            .catch { emit(emptyPreferences()) }
            .map { preferences ->
                preferences[USER_KEY] ?: ""
            }
    }

    override suspend fun saveName(name: String) {
        dataStore.edit { preferences ->
            preferences[USER_KEY] = name
        }
    }
}