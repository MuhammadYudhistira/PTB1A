package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onButtonLoginClicked(view: View) {
        val login = Intent(this, HomeActivity::class.java )
        startActivity(login)
    }
}