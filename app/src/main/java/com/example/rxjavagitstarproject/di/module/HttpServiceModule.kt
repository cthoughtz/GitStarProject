package com.example.rxjavagitstarproject.di.module

import com.example.rxjavagitstarproject.di.ApiService
import com.example.rxjavagitstarproject.di.HttpService
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class HttpServiceModule {

    @Binds
    abstract fun bindsApiService(httpService: HttpService): ApiService
}