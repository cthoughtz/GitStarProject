package com.example.rxjavagitstarproject.respository

import com.example.rxjavagitstarproject.db.Repo
import io.reactivex.Observable

class RepoRepository(val repoRemoteSource: RepoRemoteSource, val repoLocalSource: RepoLocalSource): RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return Observable.concatArray(repoLocalSource.fetchRepos(username), repoRemoteSource.fetchRepos(username))
            .doOnNext{ repos->
                saveRepos(repos)
            }
            .onErrorResumeNext(Observable.empty())
    }

    override fun saveRepos(repos: List<Repo>) {
        Observable.fromCallable {
            repoLocalSource.saveRepos(repos)
        }
    }
}