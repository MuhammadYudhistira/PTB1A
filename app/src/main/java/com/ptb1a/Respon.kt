package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ptb1a.databinding.ActivityHomeBinding
import com.ptb1a.databinding.ActivityResponBinding
import kotlinx.android.synthetic.main.activity_respon.view.*

class Respon : AppCompatActivity() {

    lateinit var binding: ActivityResponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResponBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }



    fun formRespononClicked(view: View) {
        //binding
        val Respon = binding.editRespon.text.toString()
        val ResponIntent = Intent(this, DetailLogbook::class.java )
        ResponIntent.putExtra("Respon",Respon)
        startActivity(ResponIntent)

        finish()
    }
}