package com.example.rxjavagitstarproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxjavagitstarproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        myGithubStarsRepos.setOnClickListener {
            //startActivity(Intent(applicationContext, MyStarsRepos::class.java))

            val intent = Intent(this,MyStarsRepos::class.java)
            startActivity(intent)
        }
    }
}
