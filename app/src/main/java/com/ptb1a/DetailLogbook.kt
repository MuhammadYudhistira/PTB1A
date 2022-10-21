package com.ptb1a
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ptb1a.databinding.ActivityDetailLogbookBinding
import com.ptb1a.models.Mahasiswa
import kotlinx.android.synthetic.main.activity_detail_logbook.*

private lateinit var binding: ActivityDetailLogbookBinding

class DetailLogbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("Nama")
        binding.namaDetailLogbook.text = getNama

        val getNim = intent.getStringExtra("Nim")
        binding.nimDetailLogbook.text = getNim

        val getTempat = intent.getStringExtra("Tempat")
        binding.tempatDetailLogbook.text = getTempat

        val getTanggal = intent.getStringExtra("Tanggal")
        binding.tanggalDetailLogbook.text = getTanggal

        val getCatatan = intent.getStringExtra("Catatan")
        binding.tvCatatan.text = getCatatan

        val getRespon = intent.getStringExtra("Respon")
        binding.tvRespon.text = getRespon


    }

    fun ResponClicked(view: View) {
        val Nama = binding.namaDetailLogbook.text.toString()
        val Nim = binding.nimDetailLogbook.text.toString()
        val Tempat = binding.tempatDetailLogbook.text.toString()
        val Tanggal = binding.tanggalDetailLogbook.text.toString()
        val Catatan = binding.tvCatatan.text.toString()
        val addRespon = Intent(this, Respon::class.java )
        addRespon.putExtra("Nama",Nama)
        addRespon.putExtra("Nim",Nim)
        addRespon.putExtra("Tempat",Tempat)
        addRespon.putExtra("Tanggal",Tanggal)
        addRespon.putExtra("Catatan",Catatan)
        startActivity(addRespon)
    }
}