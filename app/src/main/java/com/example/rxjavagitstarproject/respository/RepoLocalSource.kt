package com.example.rxjavagitstarproject.respository

import com.example.rxjavagitstarproject.RxApp
import com.example.rxjavagitstarproject.db.AppDatabase
import com.example.rxjavagitstarproject.db.Repo
import io.reactivex.Observable

object RepoLocalSource : RepoDataSource {

    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return Observable.fromCallable{
            AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.fetchAllMyStarsRepos()
        }

    }

    override fun saveRepos(repos: List<Repo>) {
        AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllMyStarsRepos(repos)
    }
}