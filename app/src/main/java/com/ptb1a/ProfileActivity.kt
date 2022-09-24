package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun onButtonLogoutClicked(view: View) {
        val login = Intent(this, LoginActivity::class.java )
        startActivity(login)
    }

    fun onButtonProfilBackCliked(view: View) {
        val login = Intent(this, HomeActivity::class.java )
        startActivity(login)
    }

    fun onButtonUpdateProfilClicked(view: View) {
        val login = Intent(this, UpdateProfileActivity::class.java )
        startActivity(login)
    }
}