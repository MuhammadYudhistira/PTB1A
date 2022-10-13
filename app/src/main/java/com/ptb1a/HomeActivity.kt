package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
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

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    fun onButtonProfilClicked(view: View) {
        val profil = Intent(this, ProfileActivity::class.java)
        startActivity(profil)
    }

    fun ShowDialog() {
        val view: View = layoutInflater.inflate(R.layout.bottomsheet, null)
        val dialog = BottomSheetDialog(this@HomeActivity)
        dialog.setContentView(view)
        dialog.show()

        val BtnDetailKP = dialog.findViewById<Button>(R.id.buttonDetailKP)
        BtnDetailKP?.setOnClickListener {
            Toast.makeText(this@HomeActivity, "Test", Toast.LENGTH_SHORT).show()
        }
        val BtnListLogbook = dialog.findViewById<Button>(R.id.ButtonListLogbook)
        BtnListLogbook?.setOnClickListener {
            val detailLogbook = Intent(this@HomeActivity, ListLogbook::class.java)
            startActivity(detailLogbook)
        }
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
                ShowDialog()
            }
        })

    }
}