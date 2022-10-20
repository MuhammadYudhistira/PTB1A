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

        val getRespon = intent.getStringExtra("Respon")
        binding.tvRespon.text = getRespon


    }

    fun ResponClicked(view: View) {
        val addRespon = Intent(this, Respon::class.java )
        startActivity(addRespon)
    }
}