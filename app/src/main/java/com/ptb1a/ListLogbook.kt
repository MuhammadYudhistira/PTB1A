package com.ptb1a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.Adapters.LogbookAdapter
import com.ptb1a.models.Logbook

class ListLogbook : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: LogbookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_logbook)

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
    }
}