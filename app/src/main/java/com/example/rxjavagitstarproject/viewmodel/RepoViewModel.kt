package com.example.rxjavagitstarproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavagitstarproject.model.Repo
import com.example.rxjavagitstarproject.network.GithubApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel : ViewModel() {

    val repoLiveData = MutableLiveData<ArrayList<Repo>>()
    val compositeDisposable = CompositeDisposable()


    fun getMyStarsRespo(username: String){
        val repoDisposoable = GithubApiClient.getGithubService().getStarredRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    it -> repoLiveData.value = it
            }

        compositeDisposable.add(repoDisposoable)
    }


    fun getLiveData(): LiveData<ArrayList<Repo>> = repoLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}