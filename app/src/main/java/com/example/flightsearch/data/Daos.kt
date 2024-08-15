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
}

@Dao
interface RoutesDao {
    @Query("SELECT * FROM routes WHERE departCode = :deptCode")
    fun getRoutesList(deptCode: String): Flow<List<Route>>

    @Query("UPDATE routes SET isFav = 1 WHERE departCode = :departCode AND arriveCode = :arriveCode")
    fun addToFavorite(departCode: String, arriveCode: String)

    @Query("UPDATE routes SET isFav = 0 WHERE departCode = :departCode AND arriveCode = :arriveCode")
    fun removeFromFavorite(departCode: String, arriveCode: String)
}
