package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val getNama = intent.getStringExtra("NamaMahasiswa")
        binding.tvNamaLogbook.text = getNama
        val getNim = intent.getStringExtra("NimMahasiswa")
        binding.tvNimLogbook.text = getNim
        val getTempat = intent.getStringExtra("TempatKP")
        binding.tvTempatLogbook.text = getTempat

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
                val Nama = binding.tvNamaLogbook.text.toString()
                val Nim = binding.tvNimLogbook.text.toString()
                val Tempat = binding.tvTempatLogbook.text.toString()
                val detailLogbookIntent = Intent (this@ListLogbook, DetailLogbook::class.java )
                detailLogbookIntent.putExtra("Nama",Nama)
                detailLogbookIntent.putExtra("Nim",Nim)
                detailLogbookIntent.putExtra("Tempat",Tempat)
                detailLogbookIntent.putExtra("Tanggal", data[position].tanggal)
                detailLogbookIntent.putExtra("Catatan", data[position].judul)
                startActivity(detailLogbookIntent)

            }

        })
    }
}