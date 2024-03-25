package com.bdp.bcasyariah.data

import com.bdp.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {
    @GET("Menu-Dashboard")
    suspend fun getHomeMenu() : Response<MenuDashboardResponse>
}