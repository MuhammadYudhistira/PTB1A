package com.ptb1a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.common.api.Api.Client
import com.ptb1a.PojoModels.Config
import com.ptb1a.PojoModels.KPClient
import com.ptb1a.PojoModels.LoginResponse
import com.ptb1a.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginActivity : AppCompatActivity() {

    //    private val isLoggedIn:Boolean = false
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TOKEN
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            val TAG = "LoginActivity-Debug"
//
//            if (!task.isSuccessful) {
//                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//            // Get new FCM registration token
//            val token = task.result
//
//            Log.d(TAG, token)
//            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
//        })
    }

    //binding


    fun onButtonLoginClicked(view: View) {
        val username = binding.editusername.text.toString()
        val password = binding.editPassword.text.toString()

        val client: KPClient = Config().getService()

        val call: Call<LoginResponse> = client.Login(username,password)

        call.enqueue(object: Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("login-debug", username +":" + password + t.localizedMessage)
                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                val respon: LoginResponse? = response.body();
                if (respon != null) {
                    Toast.makeText(this@LoginActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()
                    intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Username atau Password yang anda masukkan salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}