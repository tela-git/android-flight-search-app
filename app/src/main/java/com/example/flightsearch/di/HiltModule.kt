package com.example.flightsearch.di


import android.app.Application
import com.example.flightsearch.data.FlightSearchDatabase
import com.example.flightsearch.data.FlightSearchRepoImpl
import com.example.flightsearch.data.FlightSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.flightsearch.data.RecentSearchesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {


    @Provides
    @Singleton
    fun provideDatabase(app: Application): FlightSearchDatabase {
        var INSTANCE: FlightSearchDatabase? = null
        return INSTANCE ?: synchronized(this) {
            val instance =  Room.databaseBuilder(app, FlightSearchDatabase::class.java,"flight_search_db" )
                .build()
            INSTANCE = instance

            instance
        }
    }

    @Provides
    @Singleton
    fun provideFlightSearchRepo(
        database: FlightSearchDatabase
    ): FlightSearchRepository {
        return FlightSearchRepoImpl(
            database.getAirportDao(),
            database.getRoutesDao()
        )
    }

    @Provides
    @Singleton
    fun provideDataStore(app: Application): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            app.preferencesDataStoreFile("recent_search")
        }
    }

    @Provides
    fun provideRecentSearchesRepo(dataStore: DataStore<Preferences>): RecentSearchesRepository {
        return RecentSearchesRepository(dataStore)
    }
}