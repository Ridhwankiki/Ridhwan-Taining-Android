package com.bdp.bcasyariah.data.remote

import com.bdp.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response

interface MenuDashboardRemoteDatasource {

    suspend fun getMenuDashboard() : Response<MenuDashboardResponse>
}