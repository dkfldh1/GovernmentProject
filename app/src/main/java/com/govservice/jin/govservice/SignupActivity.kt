package com.govservice.jin.govservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        Log.d("메모리누수?", "흠.")
    }
}
