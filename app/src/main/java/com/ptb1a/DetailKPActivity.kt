package com.ptb1a


import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.Adapters.LogbookAdapter
import com.ptb1a.databinding.ActivityDetailKpactivityBinding


class DetailKPActivity : AppCompatActivity() {


    lateinit var adapter: LogbookAdapter
    lateinit var binding: ActivityDetailKpactivityBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("mahasiswapref", MODE_PRIVATE)?: return
        val Nama = sharedPref.getString("NAMA",null)
        val Nim = sharedPref.getString("NIM",null)
        val Tempat = sharedPref.getString("TEMPAT",null)

        binding.textContentNama.text = Nama
        binding.textContentNIM.text = Nim
        binding.textContentInstansi.text = Tempat
        
    }



    fun inputNilaiOnClick(view: View) {
        val inputNilaiIntent = Intent(this, TambahNilaiKP::class.java)
        startActivity(inputNilaiIntent)
    }
}