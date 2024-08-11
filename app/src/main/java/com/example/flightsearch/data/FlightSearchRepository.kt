package com.example.flightsearch.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface FlightSearchRepository {

    fun getAirport(searchQuery: String): Flow<List<Airport>>

    fun getRoutesList(deptCode: String): Flow<List<Route>>

    fun getFavoriteRoutesList(): Flow<List<Favorite>>
}


class FlightSearchRepoImpl @Inject constructor(
    private val airportDao: AirportDao,
    private val routeDao: RoutesDao,
    private val favoriteDao: FavoriteDao
): FlightSearchRepository {
    override fun getAirport(searchQuery: String): Flow<List<Airport>> = airportDao.getAirport(searchQuery)

    override fun getRoutesList(deptCode: String): Flow<List<Route>> = routeDao.getRoutesList(deptCode)

    override fun getFavoriteRoutesList(): Flow<List<Favorite>> = favoriteDao.getFavoriteRoutesList()
}