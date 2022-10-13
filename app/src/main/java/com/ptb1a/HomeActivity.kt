package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.Adapters.MahasiswaAdapter
import com.ptb1a.models.Mahasiswa

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun onButtonProfilClicked(view: View) {
        val profil = Intent(this, ProfileActivity::class.java)
        startActivity(profil)
    }

    fun onListMahasiswa1Clicked(view: View) {
        //ini nanti intent ke list logbook atau detail KP (bisa pakai fragment
        val ListLogbook = Intent(this, ListLogbook::class.java)
        startActivity(ListLogbook)
    }

    private fun init() {
        recyclerView = findViewById(R.id.rvListMahasiswa)

        var data = ArrayList<Mahasiswa>()
        data.add(Mahasiswa(1, null, "Muhammad Yudhistira", "2011523003"))
        data.add(Mahasiswa(1, null, "Harriko Nur Harzeki", "2011523003"))
        data.add(Mahasiswa(1, null, "Khairul Zikria", "2011523003"))
        data.add(Mahasiswa(1, null, "Muhammad Yudhistira", "2011523003"))
        data.add(Mahasiswa(1, null, "Harriko Nur Harzeki", "2011523003"))
        data.add(Mahasiswa(1, null, "Khairul Zikria", "2011523003"))
        data.add(Mahasiswa(1, null, "Muhammad Yudhistira", "2011523003"))
        data.add(Mahasiswa(1, null, "Harriko Nur Harzeki", "2011523003"))
        data.add(Mahasiswa(1, null, "Khairul Zikria", "2011523003"))

        adapter = MahasiswaAdapter(data)
        adapter.setOnClickListener(object : MahasiswaAdapter.onClickListener {

            override fun onItemClick(position: Int) {

                Toast.makeText(this@HomeActivity, "Item No. $position", Toast.LENGTH_SHORT).show()
                val detailLogbook = Intent(this@HomeActivity, ListLogbook::class.java)
                startActivity(detailLogbook)

            }


        })

    }
}