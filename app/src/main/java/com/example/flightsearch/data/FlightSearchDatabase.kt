package com.example.flightsearch.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Database(entities = [Airport::class, Route::class, Favorite::class],version = 1, exportSchema = false )
abstract class FlightSearchDatabase: RoomDatabase() {
    abstract fun getAirportDao(): AirportDao
    abstract fun getRoutesDao(): RoutesDao
    abstract fun getFavoriteDao(): FavoriteDao

    companion object {
        @Volatile
        @Singleton
        private var INSTANCE: FlightSearchDatabase? = null

        fun getDatabase(context: Context): FlightSearchDatabase {
            Log.d( "db", "getDatabase function called in companion object in Db class")
            return INSTANCE ?: synchronized(this) {
                Log.d("db","return instance is excecuted")
                val instance =  Room.databaseBuilder(context, FlightSearchDatabase::class.java,"flight_search_db" )
                    .build()
                Log.d("db",".build is called")
                INSTANCE = instance

                instance
            }
        }
    }
}