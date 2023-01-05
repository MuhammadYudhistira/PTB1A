package com.ptb1a


import android.content.Context
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.Adapters.LogbookAdapter
import com.ptb1a.PojoModels.Config
import com.ptb1a.PojoModels.KPClient
import com.ptb1a.databinding.ActivityDetailKpactivityBinding
import com.ptb1a.models.DetailKP
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailKPActivity : AppCompatActivity() {


    lateinit var adapter: LogbookAdapter
    lateinit var binding: ActivityDetailKpactivityBinding

    
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetailKpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?: return
        val token = sharedPref.getString("TOKEN",null)

//        if (token==null){
//            intent = Intent(applicationContext, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

//        val Nama = sharedPref.getString("name",null)
        //val ID = sharedPref.getInt("id",0)

        val client: KPClient = Config().getService()
        val call: Call<DetailKP> = client.getDetailKP("Bearer " + token, 2) //BELUM BERHASIL MENGAMBIL ID DARI
        //AKTIVITY HOME (RECYCLER VIEW) JADI SAYA TULIS ID SECARA MANUAL PADA PEMANGGILAN DETAIL KP

        call.enqueue(object: Callback<DetailKP> {
            override fun onResponse(
                call: Call<DetailKP>,
                response: Response<DetailKP>
            ) {
                val respon = response.body()
                Log.d("detailusulandebug", respon.toString())

                if (respon!=null){
//                    binding.textContentNama.text = Nama
//                    binding.textContentNIM.text = Nim
                    binding.textContentInstansi.text = respon.agency
                    binding.textContentJudul.text = respon.title
                    binding.textContentTanggalMulai.text = respon.startAt.toString()
                    binding.textContentTanggalSelesai.text = respon.endAt
                    binding.textContentStatus.text = respon.status.toString()
                    binding.textContentPembimbing.text = respon.supervisor
                    binding.textContentTanggalSeminar.text = respon.seminarDate
                    binding.textContentRuangSeminar.text = respon.seminarRoomName
                    binding.textContentDeadlineSeminar.text = respon.seminarDeadline.toString()
                    binding.textContentNilai.text = respon.grade

                }
            }

            override fun onFailure(call: Call<DetailKP>, t: Throwable) {
                Toast.makeText(this@DetailKPActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })



//        val Tempat = sharedPref.getString("agency",null)
//
//
//
//
//        binding.textContentNama.text = Nama
//        binding.textContentNIM.text = Nim
//        binding.textContentInstansi.text = Tempat

    }



    fun inputNilaiOnClick(view: View) {
        val inputNilaiIntent = Intent(this, TambahNilaiKP::class.java)
        startActivity(inputNilaiIntent)
    }
}