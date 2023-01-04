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
import com.ptb1a.PojoModels.UpdateLogbookResponse
import com.ptb1a.PojoModels.UpdateProfileResponse
import com.ptb1a.databinding.ActivityHomeBinding
import com.ptb1a.databinding.ActivityResponBinding
import kotlinx.android.synthetic.main.activity_detail_logbook.*
import kotlinx.android.synthetic.main.activity_respon.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Respon : AppCompatActivity() {

    lateinit var binding: ActivityResponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResponBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun formRespononClicked(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)

        val note = binding.editRespon.text.toString()

        Log.d("update-debug", "$note|Bearer $token")

        val client: KPClient = Config().getService()
        val call: Call<UpdateLogbookResponse> = client.updateLogbook(token = "Bearer $token", id = 1, id_logbook = 1, status = 2, note )
        Log.d("update-debug", "$note|Bearer $token")

        call.enqueue(object: Callback<UpdateLogbookResponse> {
            override fun onFailure(call: Call<UpdateLogbookResponse>, t: Throwable) {
                Log.d("update-debug",t.localizedMessage)
            }
            override fun onResponse(
                call: Call<UpdateLogbookResponse>,
                response: Response<UpdateLogbookResponse>
            ) {
                Log.d("update-debug", "response : $response")

                val respon: UpdateLogbookResponse? = response.body()
                if (respon != null && respon.status == "success" ) {

                    Log.d("update-debug", "$token|$respon")

                    Toast.makeText(this@Respon, "Berhasil Mengupdate Respon", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, ProfileActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@Respon, "Salah", Toast.LENGTH_SHORT).show()
                }
            }
        })



        //binding
        val getNama = intent.getStringExtra("Nama")
        val getNim = intent.getStringExtra("Nim")
        val getTempat = intent.getStringExtra("Tempat")
        val getTanggal = intent.getStringExtra("Tanggal")
        val getCatatan = intent.getStringExtra("Catatan")
        val Respon = binding.editRespon.text.toString()

        val ResponIntent = Intent(this, DetailLogbook::class.java )
        ResponIntent.putExtra("Respon",Respon)
        ResponIntent.putExtra("Nama",getNama)
        ResponIntent.putExtra("Nim",getNim)
        ResponIntent.putExtra("Tempat",getTempat)
        ResponIntent.putExtra("Tanggal",getTanggal)
        ResponIntent.putExtra("Catatan",getCatatan)
        ResponIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(ResponIntent)
        finish()
    }
}