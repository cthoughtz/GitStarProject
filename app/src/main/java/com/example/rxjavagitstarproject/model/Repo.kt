package com.example.rxjavagitstarproject.model

import com.google.gson.annotations.SerializedName

/*
* Note if the names are the same as what is in the api then you do no need
* SerializedName :)
* */

data class Repo(val name: String?, val description: String?, val language: String?,
                @SerializedName("stargazers_count") val starCount: Int?
)