package com.ptb1a
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class DetailLogbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_logbook)
    }

    fun ResponClicked(view: View) {
        val addRespon = Intent(this, Respon::class.java )
        startActivity(addRespon)
    }
}