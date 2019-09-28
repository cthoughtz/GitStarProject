package com.example.rxjavagitstarproject.respository

import com.example.rxjavagitstarproject.RxApp
import com.example.rxjavagitstarproject.db.AppDatabase
import com.example.rxjavagitstarproject.db.Repo
import com.example.rxjavagitstarproject.network.GithubApiClient
import io.reactivex.Observable

object RepoRemoteSource: RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return GithubApiClient.getGithubService().getStarredRepos(username)
    }

    override fun saveRepos(repos: List<Repo>) {
        AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllMyStarsRepos(repos)
    }
}