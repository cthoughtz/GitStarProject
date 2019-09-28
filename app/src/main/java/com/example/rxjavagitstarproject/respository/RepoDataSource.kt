package com.example.rxjavagitstarproject.respository

import com.example.rxjavagitstarproject.db.Repo
import io.reactivex.Observable

interface RepoDataSource {

    fun fetchRepos(username: String): Observable<List<Repo>>
    fun saveRepos(repo: List<Repo>)
}