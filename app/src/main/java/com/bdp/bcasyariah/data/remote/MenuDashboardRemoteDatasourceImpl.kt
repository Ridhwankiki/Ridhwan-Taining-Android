package com.bdp.bcasyariah.data.remote

import com.bdp.bcasyariah.data.Service
import com.bdp.bcasyariah.model.MenuDashboardResponse
import retrofit2.Response
import javax.inject.Inject

class MenuDashboardRemoteDatasourceImpl @Inject constructor(
    private val service: Service
) : MenuDashboardRemoteDatasource {
    override suspend fun getMenuDashboard(): Response<MenuDashboardResponse> {
        return service.getHomeMenu()
    }

}