package com.example.rxjavagitstarproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface RepoDAO {

    @Query("SELECT * FROM repo")
    fun fetchAllMyStarsRepos(): List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMyStarsRepos(repos: List<Repo>)
}