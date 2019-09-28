package com.example.rxjavagitstarproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavagitstarproject.db.Repo
import com.example.rxjavagitstarproject.network.GithubApiClient
import com.example.rxjavagitstarproject.respository.RepoLocalSource
import com.example.rxjavagitstarproject.respository.RepoRemoteSource
import com.example.rxjavagitstarproject.respository.RepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {

    val repoLiveData = MutableLiveData<List<Repo>>()
    val compositeDisposable = CompositeDisposable()
    val repository = RepoRepository(RepoRemoteSource, RepoLocalSource)


    fun getMyStarsRespo(username: String){
        val repoDisposoable = repository.fetchRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    it -> repoLiveData.value = it
            }

        compositeDisposable.add(repoDisposoable)
    }


    fun getLiveData(): LiveData<List<Repo>> = repoLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}