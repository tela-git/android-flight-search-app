package com.example.flightsearch.data

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Airport::class, Route::class, Favorite::class],version = 1, exportSchema = false )
abstract class FlightSearchDatabase: RoomDatabase() {
    abstract fun getAirportDao(): AirportDao
    abstract fun getRoutesDao(): RoutesDao
    abstract fun getFavoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: FlightSearchDatabase? = null

        fun getDatabase(context: Context): FlightSearchDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance =  Room.databaseBuilder(context, FlightSearchDatabase::class.java,"flightSearch_db" )
                    .createFromAsset("database/flight_search.db")
                    .build()
                    .also { INSTANCE = it }
                INSTANCE = instance

                instance
            }
        }
    }
}