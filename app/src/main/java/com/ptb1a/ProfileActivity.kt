package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun onButtonLogoutClicked(view: View) {
        val logout = Intent(this, LoginActivity::class.java )
        startActivity(logout)
    }

    fun onButtonProfilBackCliked(view: View) {
        val profilBack = Intent(this, HomeActivity::class.java )
        startActivity(profilBack)
    }

    fun onButtonUpdateProfilClicked(view: View) {
        val updateProfil = Intent(this, UpdateProfileActivity::class.java )
        startActivity(updateProfil)
    }

    fun onButtonChangePasswordClicked(view: View) {
        val changePassword = Intent(this, ChangePasswordActivity::class.java )
        startActivity(changePassword)
    }
}