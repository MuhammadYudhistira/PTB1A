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
import com.ptb1a.PojoModels.UpdateProfileResponse
import com.ptb1a.databinding.ActivityUpdateProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UpdateProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityUpdateProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getNama = intent.getStringExtra("Nama")
        val getEmail = intent.getStringExtra("Email")
        binding.editNama.setText(getNama)
        binding.editEmail.setText(getEmail)

    }

    fun onButtonSaveProfilClicked(view: View) {

        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)

        val name = binding.editNama.text.toString()
        val email = binding.editEmail.text.toString()

        val client: KPClient = Config().getService()
        val call: Call<UpdateProfileResponse> = client.updateProfile(token = "Bearer $token", name, email)
        Log.d("update-debug", "$name|$email|Bearer $token")

        call.enqueue(object: Callback<UpdateProfileResponse> {
            override fun onFailure(call: Call<UpdateProfileResponse>, t: Throwable) {
                Log.d("update-debug",t.localizedMessage)
            }
            override fun onResponse(call: Call<UpdateProfileResponse>, response: Response<UpdateProfileResponse>) {
                Log.d("update-debug", "response : $response")

                val respon: UpdateProfileResponse? = response.body()
                if (respon != null && respon.status == "success" ) {

                    Log.d("update-debug", "$name:$email|$token|$respon")

                    Toast.makeText(this@UpdateProfileActivity, "Berhasil Mengupdate Profile", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@UpdateProfileActivity, "Salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}