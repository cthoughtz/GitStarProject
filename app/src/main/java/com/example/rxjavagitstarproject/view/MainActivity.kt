package com.example.rxjavagitstarproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjavagitstarproject.R
import com.example.rxjavagitstarproject.di.ApiService
import com.example.rxjavagitstarproject.di.LocalStore
import com.example.rxjavagitstarproject.di.LoginManager
import com.example.rxjavagitstarproject.di.component.DaggerLoginComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginComponent = DaggerLoginComponent.create()

    }
}
