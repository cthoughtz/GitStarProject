package com.example.rxjavagitstarproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavagitstarproject.R
import com.example.rxjavagitstarproject.model.Repo
import kotlinx.android.synthetic.main.stars_item.view.*

class GibHubRepoAdapter(var data: ArrayList<Repo>) : RecyclerView.Adapter<GibHubRepoAdapter.StarRepoViewHolder>() {


     fun addRepos(repos: List<Repo>) {
        data.addAll(repos)
       notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StarRepoViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.stars_item,parent,false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: StarRepoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class StarRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val repoName = view.repoName
        val repoDesc = view.description
        val repoLang = view.language
        val repoCount = view.starsCount

        fun bind(repo: Repo) {

            repoName.text = repo.name
            repoDesc.text = repo.description
            repoLang.text = repo.language
        }
    }
}