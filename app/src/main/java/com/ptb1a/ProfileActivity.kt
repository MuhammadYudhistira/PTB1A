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
import com.ptb1a.PojoModels.User
import com.ptb1a.databinding.ActivityProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN", "")

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

        fun onButtonLogoutClicked(view: View) {
            if( token != null) {
                val client: KPClient = Config().getService()
                val call: Call<User> = client.logout(token = "Bearer " + token)

                call.enqueue(object: Callback<User> {
                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Log.d("profile-debug",t.localizedMessage)
//                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<User>, response: Response<User>) {

                        val respon = response.body()
                        Log.d("profile-debug",  "respon : "+ respon )

                    }

                })


                Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
                val logout = Intent(this, LoginActivity::class.java)
                startActivity(logout)
            }

        }
    }




    fun onButtonProfilBackCliked(view: View) {
        val profilBack = Intent(this, HomeActivity::class.java )
        startActivity(profilBack)
    }

    fun onButtonUpdateProfilClicked(view: View) {
        val updateProfil = Intent(this, UpdateProfileActivity::class.java )
        startActivity(updateProfil)
    }

    fun onButtonChangePasswordClicked(view: View) {
        val changePassword = Intent(this, ChangePasswordActivity::class.java )
        startActivity(changePassword)
    }
}