package com.example.rxjavagitstarproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavagitstarproject.R
import com.example.rxjavagitstarproject.view.adapter.GibHubRepoAdapter
import com.example.rxjavagitstarproject.model.Repo
import com.example.rxjavagitstarproject.network.GithubApiClient
import com.example.rxjavagitstarproject.viewmodel.RepoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_my_stars_repos.*

class MyStarsRepos : AppCompatActivity() {

    val repoAdapter = GibHubRepoAdapter(arrayListOf())
    var repoList = ArrayList<Repo>()
    private lateinit var repoViewModel: RepoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)



        val divider = DividerItemDecoration(myStarsList.context, DividerItemDecoration.VERTICAL)

        myStarsList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = repoAdapter
            addItemDecoration(divider)
        }

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)


        getStarredRepos(repoViewModel)
        obserMyStars(repoViewModel)
    }

    fun getStarredRepos(viewModel: RepoViewModel) {
        viewModel.getMyStarsRespo(("mrabelwahed"))
    }

    fun obserMyStars(viewModel: RepoViewModel) {
        viewModel.getLiveData().observe(this, Observer {
            repos -> repoAdapter.addRepos(repos)
        })
    }
}
