package com.example.flightsearch.data

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class RecentSearchesRepository @Inject constructor(
   private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val RECENT_SEARCH = stringPreferencesKey("recent_search")
    }

    suspend fun saveSearchedString(recentSearch: String) {
        dataStore.edit {
            it[RECENT_SEARCH] = recentSearch
        }
    }

    val recentSearch: Flow<String> = dataStore.data
        .catch {
            if(it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map {
        it[RECENT_SEARCH] ?: ""
    }

}