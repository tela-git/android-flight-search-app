package com.example.flightsearch.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Database(entities = [Airport::class, Route::class],version = 1, exportSchema = false )
abstract class FlightSearchDatabase: RoomDatabase() {
    abstract fun getAirportDao(): AirportDao
    abstract fun getRoutesDao(): RoutesDao

}