package com.govservice.jin.govservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlin.math.log2

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener(this)
        button_signup_with_email.setOnClickListener(this)
        button_signup_with_facebook.setOnClickListener(this)
        button_signup_with_google.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_login -> {
                startActivity(Intent(this, MainActivity::class.java))
                Log.d("login", "login")
            }
            R.id.button_signup_with_email -> {
                startActivity(Intent(this, SignupActivity::class.java))
                Log.d("email", "email")
            }
            R.id.button_signup_with_facebook -> {
                Log.d("facebook", "facebook")
            }
            R.id.button_signup_with_google -> {
                Log.d("google", "google")
            }

        }
    }


}