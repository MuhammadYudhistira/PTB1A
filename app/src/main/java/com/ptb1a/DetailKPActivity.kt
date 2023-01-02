package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DetailKPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kpactivity)
    }



    fun inputNilaiOnClick(view: View) {
        val inputNilaiIntent = Intent(this, TambahNilaiKP::class.java)
        startActivity(inputNilaiIntent)
    }
}