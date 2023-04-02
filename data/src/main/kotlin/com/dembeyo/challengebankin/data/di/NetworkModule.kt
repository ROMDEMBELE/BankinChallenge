package com.dembeyo.challengebankin.data.di

import com.dembeyo.challengebankin.data.network.service.CategoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideCategoryService() = CategoryService()
}