package com.ptb1a

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ptb1a.Adapters.MahasiswaAdapter
import com.ptb1a.databinding.ActivityHomeBinding
import com.ptb1a.models.Mahasiswa

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaAdapter
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)
        Log.d("home-debug","Token : "+ token.toString())

        if(token == null) {
            Log.d("home-debug", "Token : " + token.toString())
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun harianOnClick(view: View) {
        val harian = Intent(this, LogbookHarian::class.java)
        startActivity(harian)
    }
    fun profileOnClick(view: View) {
        val profil = Intent(this, ProfileActivity::class.java)
        startActivity(profil)
    }

    //Recycler View
    private fun init() {
        recyclerView = binding.rvListMahasiswa

        var data = ArrayList<Mahasiswa>()
        data.add(Mahasiswa(1, null, "Muhammad Yudhistira", "2011523003", "Google"))
        data.add(Mahasiswa(2, null, "Harriko Nur Harzeki", "2011521024", "Amazon"))
        data.add(Mahasiswa(3, null, "Khairul Zikria", "1911522001", "Meta"))
        data.add(Mahasiswa(4, null, "Muhammad Yudhistira", "2011523003", "Google"))
        data.add(Mahasiswa(5, null, "Harriko Nur Harzeki", "2011521024", "Amazon"))
        data.add(Mahasiswa(6, null, "Khairul Zikria", "1911522001", "Meta"))
        data.add(Mahasiswa(7, null, "Muhammad Yudhistira", "2011523003", "Google"))
        data.add(Mahasiswa(8, null, "Harriko Nur Harzeki", "2011521024", "Amazon"))
        data.add(Mahasiswa(9, null, "Khairul Zikria", "1911522001", "Meta"))

        adapter = MahasiswaAdapter(data)
        //Item Click Recycler View
        adapter.setOnClickListener(object : MahasiswaAdapter.onClickListener {
            override fun onItemClick(position: Int) {
                //Buttom Sheet Modal
                val view: View = layoutInflater.inflate(R.layout.bottomsheet, null)
                val dialog = BottomSheetDialog(this@HomeActivity)
                dialog.setContentView(view)
                dialog.show()

                val BtnDetailKP = dialog.findViewById<Button>(R.id.buttonDetailKP)
                BtnDetailKP?.setOnClickListener {

                    val sharedPref = getSharedPreferences("mahasiswapref", MODE_PRIVATE) ?: return@setOnClickListener
                    with (sharedPref.edit()) {
                        putString("NAMA", data[position].Nama)
                        putString("NIM", data[position].Nim)
                        putString("TEMPAT", data[position].Tempat)

                        apply()
                    }


                    val detailKPIntent = Intent(this@HomeActivity, DetailKPActivity::class.java)
                    startActivity(detailKPIntent)
                    dialog.dismiss()
                }
                val BtnListLogbook = dialog.findViewById<Button>(R.id.ButtonListLogbook)
                BtnListLogbook?.setOnClickListener {

                    val sharedPref = getSharedPreferences("mahasiswapref", MODE_PRIVATE) ?: return@setOnClickListener
                    with (sharedPref.edit()) {
                        putString("NAMA", data[position].Nama)
                        putString("NIM", data[position].Nim)
                        putString("TEMPAT", data[position].Tempat)
                        putString("PROFIL", data[position].profil.toString())
                        apply()
                    }
                    val listLogbookIntent = Intent(this@HomeActivity, ListLogbook::class.java)
                    startActivity(listLogbookIntent)
                    dialog.dismiss()
                }
            }
        })
    }
}
