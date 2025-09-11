package com.example.mobile_app_final_assignment.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.mobile_app_final_assignment.network.ApiDevService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeDiModule {

    @Provides
    @Singleton
    fun provideApiDevService(
    ): ApiDevService {
        return ApiDevRetrofitClient().apiService
    }
}