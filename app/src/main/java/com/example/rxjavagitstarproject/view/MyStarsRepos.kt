package com.example.rxjavagitstarproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavagitstarproject.R
import com.example.rxjavagitstarproject.adapter.GibHubRepoAdapter
import com.example.rxjavagitstarproject.model.Repo
import kotlinx.android.synthetic.main.activity_my_stars_repos.*

class MyStarsRepos : AppCompatActivity() {

    val myAdapter = GibHubRepoAdapter(arrayListOf())
    var repoList = ArrayList<Repo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_stars_repos)



        //mock data
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )
        repoList.add(
            Repo(
                "Rxjava",
                "Rxjava is an amazing library for your life",
                "Java"
            )
        )


        myAdapter.addRepos(repoList)

        myStarsList.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = myAdapter
        }


    }
}
