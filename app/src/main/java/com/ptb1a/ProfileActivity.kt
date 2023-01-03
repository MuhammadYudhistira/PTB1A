package com.ptb1a

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ptb1a.PojoModels.Config
import com.ptb1a.PojoModels.KPClient
import com.ptb1a.PojoModels.LogoutResponse
import com.ptb1a.PojoModels.User
import com.ptb1a.databinding.ActivityProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN", null)

        if(token != null){
            Log.d("token", token)
            super.onCreate(savedInstanceState)
            binding = ActivityProfileBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

        val client: KPClient = Config().getService()
        val call: Call<User> = client.profile(token = "Bearer "+token)

        call.enqueue(object: Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("profile-debug",t.localizedMessage)
//                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {

                val respon = response.body()
                Log.d("profile-debug",  "respon : "+ respon )

                val getNama = respon?.name
                binding.accountName.text = getNama

                val email = respon?.email
                binding.accountEmail.text = email

                val username = respon?.username
                binding.accountUsername.text = username

                }

        })

        val buttonLogout = binding.buttonLogout

        buttonLogout.setOnClickListener{
            if( token != null) {
                val client: KPClient = Config().getService()
                val call: Call<LogoutResponse> = client.logout(token = "Bearer " + token)

                call.enqueue(object: Callback<LogoutResponse> {
                    override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                        Log.d("logout-debug",t.localizedMessage)
                    }
                    override fun onResponse(call: Call<LogoutResponse>, response: Response<LogoutResponse>) {

                        val respon = response.body()

                        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?:return
                        with (sharedPref.edit()) {
                            putString("TOKEN", null)
                            apply()
                        }
                        Log.d("logout-debug",  "respon : "+ respon )
                        Toast.makeText(this@ProfileActivity, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                        val logout = Intent(this@ProfileActivity, LoginActivity::class.java)
                        logout.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(logout)
                        finish()
                    }

                })

            }
        }


    }

    fun onButtonUpdateProfilClicked(view: View) {

        val nama = binding.accountName.text.toString()
        val email = binding.accountEmail.text.toString()
        val updateProfil = Intent(this, UpdateProfileActivity::class.java )
        updateProfil.putExtra("Nama", nama)
        updateProfil.putExtra("Email", email)

        startActivity(updateProfil)
    }

    fun onButtonChangePasswordClicked(view: View) {
        val changePassword = Intent(this, ChangePasswordActivity::class.java )
        startActivity(changePassword)
    }
}