package com.bdp.bcasyariah.di

import com.bdp.bcasyariah.data.Service
import com.bdp.bcasyariah.data.remote.MenuDashboardRemoteDatasource
import com.bdp.bcasyariah.data.remote.MenuDashboardRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MenuModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service: Service) : MenuDashboardRemoteDatasource {
        return MenuDashboardRemoteDatasourceImpl(service)
    }
}