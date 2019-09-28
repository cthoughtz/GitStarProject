package com.example.rxjavagitstarproject.network

import com.example.rxjavagitstarproject.db.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{user}/starred")
    fun getStarredRepos(@Path("user") usrename: String): Observable<List<Repo>>
}