package com.example.mobile_app_final_assignment.viewmodels

import com.example.mobile_app_final_assignment.network.ApiDevRetrofitClient
import com.example.mobile_app_final_assignment.network.ApiDevService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HomeDiModule {

    @Provides
    fun provideRestfulApiDevService(
    ): ApiDevService {
        return ApiDevRetrofitClient().apiService
    }
}