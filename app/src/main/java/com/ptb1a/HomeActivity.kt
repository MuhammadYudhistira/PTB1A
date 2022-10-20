package com.ptb1a

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
import kotlinx.android.synthetic.main.itemmahasiswa.view.*

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MahasiswaAdapter
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun onButtonProfilClicked(view: View) {
        val profil = Intent(this, ProfileActivity::class.java)
        startActivity(profil)
    }
    //Recycler View
    private fun init() {
        recyclerView = findViewById(R.id.rvListMahasiswa)

        var data = ArrayList<Mahasiswa>()
        data.add(Mahasiswa(1, null, "Muhammad Yudhistira", "2011523003", "Google"))
        data.add(Mahasiswa(2, null, "Harriko Nur Harzeki", "2011523003", "Amazon"))
        data.add(Mahasiswa(3, null, "Khairul Zikria", "2011523003", "Meta"))
        data.add(Mahasiswa(4, null, "Muhammad Yudhistira", "2011523003", "Google"))
        data.add(Mahasiswa(5, null, "Harriko Nur Harzeki", "2011523003", "Amazon"))
        data.add(Mahasiswa(6, null, "Khairul Zikria", "2011523003", "Meta"))
        data.add(Mahasiswa(7, null, "Muhammad Yudhistira", "2011523003", "Google"))
        data.add(Mahasiswa(8, null, "Harriko Nur Harzeki", "2011523003", "Amazon"))
        data.add(Mahasiswa(9, null, "Khairul Zikria", "2011523003", "Meta"))

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
                    val Nama = binding.rvListMahasiswa.tvNamaMahasiswa.text.toString()

                    val listLogbookIntent = Intent(this@HomeActivity, ListLogbook::class.java)
                    listLogbookIntent.putExtra("NamaMahasiswa",Nama)
                    startActivity(listLogbookIntent)
                    dialog.dismiss()
                }
            }
        })
    }
}