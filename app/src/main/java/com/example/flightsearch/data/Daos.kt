package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
}

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites")
    fun getFavoriteRoutesList(): Flow<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToFavorites(route: Route)
}