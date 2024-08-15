package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface AirportDao {
    @Query("SELECT * FROM airports WHERE iataCode LIKE :searchQuery || '%' OR name LIKE :searchQuery || '%'")
    fun getAirport(searchQuery: String): Flow<List<Airport>>

    @Query("SELECT name FROM airports WHERE iataCode = :airportCode")
    suspend fun getAirportNameByCode(airportCode: String): String
}

@Dao
interface RoutesDao {
    @Query("SELECT * FROM routes WHERE departCode = :deptCode")
    fun getRoutesList(deptCode: String): Flow<List<Route>>

    @Query("SELECT * FROM routes WHERE isFav = 1")
    fun getFavRoutesList(): Flow<List<Route>>

    @Query("UPDATE routes SET isFav = 1 WHERE departCode = :departCode AND arriveCode = :arriveCode")
    suspend fun addToFavorite(departCode: String, arriveCode: String)

    @Query("UPDATE routes SET isFav = 0 WHERE departCode = :departCode AND arriveCode = :arriveCode")
    suspend fun removeFromFavorite(departCode: String, arriveCode: String)
}
