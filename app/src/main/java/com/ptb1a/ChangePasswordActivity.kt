package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
    }

    fun onButtonPasswordBackClicked(view: View) {
        val backPassword = Intent(this, ProfileActivity::class.java )
        startActivity(backPassword)
    }

    fun onButtonSavePasswordClicked(view: View) {
        Toast.makeText(this, "Password Berhasil Diubah", Toast.LENGTH_SHORT).show()
        val savePassword = Intent(this, ProfileActivity::class.java )
        startActivity(savePassword)
        finish()
    }
}