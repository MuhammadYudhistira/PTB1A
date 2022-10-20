package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Respon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respon)
    }

    fun formRespononClicked(view: View) {
        Toast.makeText(this,"Berhasil Menambahkan Respon",Toast.LENGTH_SHORT).show()
        val Respon = Intent(this, DetailLogbook::class.java )
        startActivity(Respon)
        finish()
    }
}