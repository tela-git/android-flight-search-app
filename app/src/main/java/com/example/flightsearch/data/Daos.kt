package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface AirportDao {
    @Query("SELECT * FROM airPorts WHERE iataCode LIKE :searchQuery || '%' OR name LIKE :searchQuery || '%'")
    fun getAirport(searchQuery: String): Flow<List<Airport>>
}

@Dao
interface RoutesDao {
    
}

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites")
    fun getFavoriteRoutesList(): Flow<List<Favorite>>
}