package com.example.flightsearch.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airports")
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    val name: String,
    val iataCode: String,
    val passengers: Int

)

@Entity(tableName = "routes")
data class Route(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    val departCode: String,
    val arriveCode: String,
    val isFav: Boolean
)