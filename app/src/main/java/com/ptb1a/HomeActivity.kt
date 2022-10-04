package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun onButtonProfilClicked(view: View) {
        val login = Intent(this, ProfileActivity::class.java )
        startActivity(login)
    }

    fun onListMahasiswa1Clicked(view: View) {
        //ini nanti intent ke list logbook atau detail KP (bisa pakai fragment
        val ListLogbook = Intent(this, ListLogbook::class.java )
        startActivity(ListLogbook)
    }
}