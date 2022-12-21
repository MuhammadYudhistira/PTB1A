package com.ptb1a

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.Adapters.LogbookAdapter
import com.ptb1a.databinding.ActivityListLogbookBinding
import com.ptb1a.models.Logbook

class ListLogbook : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: LogbookAdapter
    lateinit var binding: ActivityListLogbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityListLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("mahasiswapref", Context.MODE_PRIVATE)?: return
        val Nama = sharedPref.getString("NAMA",null)
        val Nim = sharedPref.getString("NIM",null)
        val Tempat = sharedPref.getString("TEMPAT",null)
        val Profil = sharedPref.getString("PROFIL",null)
        binding.tvNamaLogbook.text = Nama
        binding.tvNimLogbook.text = Nim
        binding.tvTempatLogbook.text = Tempat
        binding.imageView4.setImageDrawable(Drawable.createFromPath(Profil))
        Log.d("list-debug", Profil.toString())

        init ()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView = findViewById(R.id.rvLogbook)

        var data = ArrayList<Logbook>()
        data.add(Logbook(1, "Senin, 6 September 2022", "Mencari Objek",))
        data.add(Logbook(2, "Selasa, 7 September 2022", "Merancang Project",))
        data.add(Logbook(3, "Rabu, 8 September 2022", "Melakukan Project",))
        data.add(Logbook(4, "Kamis, 9 September 2022", "Mencari Objek",))
        data.add(Logbook(5, "Jumat, 10 September 2022", "Merancang Project",))
        data.add(Logbook(6, "Sabtu, 11 September 2022", "Melakukan Project",))
        data.add(Logbook(7, "Minggu, 12 September 2022", "Mencari Objek",))
        data.add(Logbook(8, "Senin, 6 September 2022", "Merancang Project",))
        data.add(Logbook(9, "Selasa, 7 September 2022", "Melakukan Project",))
        data.add(Logbook(10, "Rabu, 8 September 2022", "Mencari Objek",))
        data.add(Logbook(11, "Kamis, 9 September 2022", "Merancang Project",))
        data.add(Logbook(12, "Jumat, 10 September 2022", "Melakukan Project",))
        data.add(Logbook(13, "Sabtu, 11 September 2022", "Mencari Objek",))
        data.add(Logbook(14, "Minggu, 12 September 2022", "Merancang Project",))
        data.add(Logbook(15, "Senin, 13 September 2022", "Melakukan Project",))

        adapter = LogbookAdapter(data)
        adapter.setOnClickListener(object : LogbookAdapter.clickListener {

            override fun onItemClick(position: Int) {
                //binding
                val sharedPref = getSharedPreferences("logbookpref", MODE_PRIVATE) ?: return
                with (sharedPref.edit()) {
                    putString("TANGGAL", data[position].tanggal)
                    putString("JUDUL", data[position].judul)
                    apply()
                }
                val detailLogbookIntent = Intent (this@ListLogbook, DetailLogbook::class.java )
                startActivity(detailLogbookIntent)

            }

        })
    }
}