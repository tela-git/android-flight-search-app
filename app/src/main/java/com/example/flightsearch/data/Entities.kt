package com.example.flightsearch.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airPorts")
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val iataCode: String,
    val name: String,
    val passengers: Int
)

@Entity(tableName = "routes")
data class Route(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val departCode: String,
    val arriveCode: String
)

@Entity(tableName = "favorites")
data class Favorite(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val departCode: String,
    val arriveCode: String
)