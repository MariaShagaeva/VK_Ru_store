package com.shagaeva.rustore.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Расширение для доступа к DataStore
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "rustore_prefs")

class DataStoreManager(private val context: Context) {

    companion object {
        private val ONBOARDING_COMPLETED_KEY = booleanPreferencesKey("onboarding_completed")
    }

    suspend fun saveOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ONBOARDING_COMPLETED_KEY] = completed
        }
    }

    val getOnboardingCompleted: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[ONBOARDING_COMPLETED_KEY] ?: false
        }
}