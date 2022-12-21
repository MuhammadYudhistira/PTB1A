package com.ptb1a

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ptb1a.PojoModels.*
import com.ptb1a.databinding.ActivityChangePasswordBinding
import com.ptb1a.databinding.ActivityUpdateProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChangePasswordActivity : AppCompatActivity() {

    lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onButtonSavePasswordClicked(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)

        val old_password = binding.editCurrentPassword.text.toString()
        val new_password = binding.editNewPassword.text.toString()
        val confirm_password = binding.editRetypePassword.text.toString()

        val client: KPClient = Config().getService()
        val call: Call<UpdatePasswordResponse> = client.updatePassword(token = "Bearer $token", old_password, new_password,confirm_password)
        Log.d("update-debug", "$old_password|$new_password|$confirm_password|Bearer $token")

        call.enqueue(object: Callback<UpdatePasswordResponse> {
            override fun onFailure(call: Call<UpdatePasswordResponse>, t: Throwable) {
                Log.d("update-debug",t.localizedMessage)
            }
            override fun onResponse(call: Call<UpdatePasswordResponse>, response: Response<UpdatePasswordResponse>) {
                Log.d("update-debug", "response : $response")

                val respon: UpdatePasswordResponse? = response.body()
                if (respon != null && respon.status == "success" && new_password == confirm_password) {

                    Log.d("update-debug", "$old_password:$new_password|$confirm_password|$token|$respon")

                    Toast.makeText(this@ChangePasswordActivity, "Berhasil Mengupdate password", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@ChangePasswordActivity, "Password & Confirm Passowrd Salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}