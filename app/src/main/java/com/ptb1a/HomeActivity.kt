package com.ptb1a

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN", "")

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
                    Toast.makeText(this@HomeActivity, "Detail KP", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                val BtnListLogbook = dialog.findViewById<Button>(R.id.ButtonListLogbook)
                BtnListLogbook?.setOnClickListener {
                    val listLogbookIntent = Intent(this@HomeActivity, ListLogbook::class.java)
                    //binding
                    listLogbookIntent.putExtra("NamaMahasiswa", data[position].Nama)
                    listLogbookIntent.putExtra("NimMahasiswa", data[position].Nim)
                    listLogbookIntent.putExtra("TempatKP", data[position].Tempat)
                    startActivity(listLogbookIntent)
                    dialog.dismiss()
                }
            }
        })
    }



}
