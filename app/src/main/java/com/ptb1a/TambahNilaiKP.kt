package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TambahNilaiKP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_nilai_kp)
    }

    fun onClickListener(view: View) {
        val backIntent = Intent(this, DetailKPActivity::class.java)
        startActivity(backIntent)
    }
}