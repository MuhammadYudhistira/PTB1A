package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
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


        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            val TAG = "HomeActivity-Debug"

            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }
            // Get new FCM registration token
            val token = task.result

            Log.d(TAG, token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        })
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