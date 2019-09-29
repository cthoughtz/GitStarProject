package com.example.rxjavagitstarproject.di

import javax.inject.Inject

class LoginManager @Inject constructor(val localStore: LocalStore, val apiService: ApiService) {

    fun login(username: String, password: String) {

    }

    @Inject
    fun enabledCache(cache: Cache) {
        cache.registerCasche(this)
    }
}