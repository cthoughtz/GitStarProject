package com.example.rxjavagitstarproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavagitstarproject.R
import com.example.rxjavagitstarproject.view.adapter.GibHubRepoAdapter
import com.example.rxjavagitstarproject.model.Repo
import com.example.rxjavagitstarproject.network.GithubApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_my_stars_repos.*

class MyStarsRepos : AppCompatActivity() {

    val repoAdapter = GibHubRepoAdapter(arrayListOf())
    var repoList = ArrayList<Repo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)






        myStarsList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = repoAdapter
        }
    }

    fun getStarredRepos() {
        GithubApiClient.getGithubService().getStarredRepos("mrabelwahed")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it ->
                repoAdapter.addRepos(it)
            }
    }
}
