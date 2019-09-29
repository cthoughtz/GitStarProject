package com.example.rxjavagitstarproject.di.component

import com.example.rxjavagitstarproject.di.LoginManager
import com.example.rxjavagitstarproject.di.module.HttpServiceModule
import com.example.rxjavagitstarproject.di.module.localStoreModule
import com.example.rxjavagitstarproject.view.MainActivity
import dagger.Component

@Component(modules = [localStoreModule::class, HttpServiceModule::class])
interface LoginComponent {
    fun inject(mainActivity: MainActivity)
}