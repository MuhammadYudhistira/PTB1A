package com.ptb1a

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ptb1a.databinding.ActivityProfileBinding



class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
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