package com.ptb1a

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ptb1a.PojoModels.Config
import com.ptb1a.PojoModels.KPClient
import com.ptb1a.PojoModels.LoginResponse
import com.ptb1a.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)

        if(token != null){
            Log.d("login-debug","Token : "+ token.toString())
            intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

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

    fun onButtonLoginClicked(view: View) {
        val username = binding.editUsername.text.toString()
        val password = binding.editPassword.text.toString()

        val client: KPClient = Config().getService()

        val call: Call<LoginResponse> = client.login(username,password)

        call.enqueue(object: Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("login-debug",t.localizedMessage)
//                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                //ambil respon login
                val respon: LoginResponse? = response.body();
                if (respon != null && respon.status == "success" ) {

                    //ambil Token
                    val token = respon.authorisation?.token
                    val user = respon.user

                    Log.d("login-debug", "$username:$password|$token|$respon")

                    //Shared Preference
                    val sharedPref = getSharedPreferences("sharedpref", MODE_PRIVATE) ?:return
                    with (sharedPref.edit()) {
                        putString("TOKEN", token)
                        putString("USER", user.toString())
                        apply()
                    }

                    Toast.makeText(this@LoginActivity, "Login Berhasil", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@LoginActivity, "Username atau Password yang anda masukkan salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}