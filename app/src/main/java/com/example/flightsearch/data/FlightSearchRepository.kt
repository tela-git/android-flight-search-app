package com.example.flightsearch.data

import android.util.Log
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface FlightSearchRepository {

    fun getAirport(searchQuery: String): Flow<List<Airport>>

    fun getRoutesList(deptCode: String): Flow<List<Route>>

    fun getFavoriteRoutesList(): Flow<List<Route>>

    suspend fun getAirportNameByCode(iataCode: String): String

    suspend fun addToFavorite(departCode: String, arriveCode: String)

    suspend fun removeFromFavorite(departCode: String, arriveCode: String)
}


class FlightSearchRepoImpl @Inject constructor(
    private val airportDao: AirportDao,
    private val routeDao: RoutesDao,
): FlightSearchRepository {
    override fun getAirport(searchQuery: String): Flow<List<Airport>> = airportDao.getAirport(searchQuery)

    override fun getRoutesList(deptCode: String): Flow<List<Route>> = routeDao.getRoutesList(deptCode)

    override suspend fun getAirportNameByCode(iataCode: String): String = airportDao.getAirportNameByCode(iataCode)

    override fun getFavoriteRoutesList(): Flow<List<Route>> = routeDao.getFavRoutesList()


    override suspend fun addToFavorite(departCode: String, arriveCode: String) = routeDao.addToFavorite(departCode = departCode, arriveCode = arriveCode)

    override suspend fun removeFromFavorite(departCode: String, arriveCode: String) = routeDao.removeFromFavorite(departCode = departCode, arriveCode = arriveCode)
}