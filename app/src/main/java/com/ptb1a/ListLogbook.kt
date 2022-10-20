package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        binding.tvNamaLogbook.text = getNama.toString()

        init ()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init(){
        recyclerView = findViewById(R.id.rvLogbook)

        var data = ArrayList<Logbook>()
        data.add(Logbook(1, "Senin, 6 September 2022", "Mencari Objek",))
        data.add(Logbook(2, "Selasa, 7 September 2022", "Mencari Objek",))
        data.add(Logbook(3, "Rabu, 8 September 2022", "Mencari Objek",))
        data.add(Logbook(4, "Kamis, 9 September 2022", "Mencari Objek",))
        data.add(Logbook(5, "Jumat, 10 September 2022", "Mencari Objek",))
        data.add(Logbook(6, "Sabtu, 11 September 2022", "Mencari Objek",))
        data.add(Logbook(7, "Minggu, 12 September 2022", "Mencari Objek",))
        data.add(Logbook(1, "Senin, 6 September 2022", "Mencari Objek",))
        data.add(Logbook(2, "Selasa, 7 September 2022", "Mencari Objek",))
        data.add(Logbook(3, "Rabu, 8 September 2022", "Mencari Objek",))
        data.add(Logbook(4, "Kamis, 9 September 2022", "Mencari Objek",))
        data.add(Logbook(5, "Jumat, 10 September 2022", "Mencari Objek",))
        data.add(Logbook(6, "Sabtu, 11 September 2022", "Mencari Objek",))
        data.add(Logbook(7, "Minggu, 12 September 2022", "Mencari Objek",))

        adapter = LogbookAdapter(data)
        adapter.setOnClickListener(object : LogbookAdapter.clickListener {

            override fun onItemClick(position: Int) {

                Toast.makeText(this@ListLogbook, "Item No. $position", Toast.LENGTH_SHORT).show()
                val detailLogbook = Intent (this@ListLogbook, DetailLogbook::class.java )
                startActivity(detailLogbook)

            }

        })
    }
}