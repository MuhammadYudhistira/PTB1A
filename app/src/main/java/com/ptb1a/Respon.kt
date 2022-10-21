package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ptb1a.databinding.ActivityHomeBinding
import com.ptb1a.databinding.ActivityResponBinding
import kotlinx.android.synthetic.main.activity_detail_logbook.*
import kotlinx.android.synthetic.main.activity_respon.view.*

class Respon : AppCompatActivity() {

    lateinit var binding: ActivityResponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResponBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }



    fun formRespononClicked(view: View) {
        //binding
        val getNama = intent.getStringExtra("Nama")
        val getNim = intent.getStringExtra("Nim")
        val getTempat = intent.getStringExtra("Tempat")
        val getTanggal = intent.getStringExtra("Tanggal")
        val getCatatan = intent.getStringExtra("Catatan")
        val Respon = binding.editRespon.text.toString()

        val ResponIntent = Intent(this, DetailLogbook::class.java )
        ResponIntent.putExtra("Respon",Respon)
        ResponIntent.putExtra("Nama",getNama)
        ResponIntent.putExtra("Nim",getNim)
        ResponIntent.putExtra("Tempat",getTempat)
        ResponIntent.putExtra("Tanggal",getTanggal)
        ResponIntent.putExtra("Catatan",getCatatan)

        startActivity(ResponIntent)

        finish()
    }
}