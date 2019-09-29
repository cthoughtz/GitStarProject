package com.example.rxjavagitstarproject.di.module

import com.example.rxjavagitstarproject.di.LocalStore
import dagger.Module
import dagger.Provides

@Module
class localStoreModule {

    @Provides
    fun providesLocalStore() = LocalStore()
}