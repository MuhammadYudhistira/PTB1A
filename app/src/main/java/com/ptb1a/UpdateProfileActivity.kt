package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class UpdateProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)
    }

    fun onButtonUpdateBackClicked(view: View) {
        val backProfil = Intent(this, ProfileActivity::class.java )
        startActivity(backProfil)
    }

    fun onButtonSaveProfilClicked(view: View) {
        Toast.makeText(this, "Perubahan Disimpan", Toast.LENGTH_SHORT).show()
        val saveProfil = Intent(this, ProfileActivity::class.java )
        startActivity(saveProfil)
    }
}