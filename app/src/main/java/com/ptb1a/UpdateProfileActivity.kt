package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UpdateProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
    }

    fun onButtonUpdateBackClicked(view: View) {
        val login = Intent(this, ProfileActivity::class.java )
        startActivity(login)
    }

    fun onButtonSaveProfilClicked(view: View) {
        val login = Intent(this, ProfileActivity::class.java )
        startActivity(login)
    }
}