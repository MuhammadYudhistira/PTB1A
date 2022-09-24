package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class DetailLogbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_logbook)
    }

    fun RespononClicked(view: View) {
        val toast = Toast.makeText(applicationContext, "Berhasil Mengupdate Respon", LENGTH_SHORT)
        toast.show()
    }
}