package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.ptb1a.databinding.ActivityDetailLogbookBinding
import com.ptb1a.databinding.ActivityLoginBinding
import com.ptb1a.databinding.ActivityResponBinding

class LoginActivity : AppCompatActivity() {

//    private val isLoggedIn:Boolean = false
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onButtonLoginClicked(view: View) {
        val login = Intent(this, HomeActivity::class.java )
        startActivity(login)
        finish()
    }

//    val login = if(!isLoggedIn){
//        val loginIntent = Intent(this, LoginActivity::class.java )
//        startActivity(loginIntent)
//    } else {
//
//    }
}