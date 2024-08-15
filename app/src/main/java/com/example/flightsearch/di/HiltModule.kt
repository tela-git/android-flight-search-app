package com.example.flightsearch.di


import com.example.flightsearch.data.FlightSearchDatabase
import com.example.flightsearch.data.FlightSearchRepoImpl
import com.example.flightsearch.data.FlightSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideFlightSearchRepo(
        @ApplicationContext context: Context
    ): FlightSearchRepository {
        return FlightSearchRepoImpl(
            FlightSearchDatabase.getDatabase(context).getAirportDao(),
            FlightSearchDatabase.getDatabase(context).getRoutesDao()
        )
    }
}