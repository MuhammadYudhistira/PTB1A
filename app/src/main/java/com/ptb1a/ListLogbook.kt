package com.ptb1a

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.Adapters.LogbookAdapter
import com.ptb1a.PojoModels.Config
import com.ptb1a.PojoModels.KPClient
import com.ptb1a.PojoModels.ListLogbookResponse
import com.ptb1a.PojoModels.LogbookItem
import com.ptb1a.databinding.ActivityListLogbookBinding
import com.ptb1a.models.Logbook
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListLogbook : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityListLogbookBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityListLogbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = LogbookAdapter()

        val sharedToken = getSharedPreferences("sharedpref", Context.MODE_PRIVATE) ?: return
        val token = sharedToken.getString("TOKEN", null)

        val sharedPref = getSharedPreferences("mahasiswapref", Context.MODE_PRIVATE) ?: return
        val Nama = sharedPref.getString("NAMA", null)
        val Nim = sharedPref.getString("NIM", null)
        val Tempat = sharedPref.getString("TEMPAT", null)
        val id = sharedPref.getInt("ID", 0)

        binding.tvNamaLogbook.text = Nama
        binding.tvNimLogbook.text = Nim
        binding.tvTempatLogbook.text = Tempat


        val data = ArrayList<LogbookItem>()
        recyclerView = binding.rvLogbook

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        Log.d("list-debug", token.toString())

        val client: KPClient = Config().getService()
        val call: Call<ListLogbookResponse> = client.listlogbook(token = "Bearer " + token, id)

        call.enqueue(object : Callback<ListLogbookResponse> {
            override fun onFailure(call: Call<ListLogbookResponse>, t: Throwable) {
                Log.d("list-debug", t.localizedMessage)
//                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ListLogbookResponse>,
                response: Response<ListLogbookResponse>
            ) {
                val respon = response.body()
                if (respon != null) {
                    val list: List<LogbookItem> = respon.logbooks as List<LogbookItem>
                    adapter.setlistLogbook(list)
                    Log.d("list-debug", list.toString())
                }
                Log.d("list-debug", respon?.logbooks?.size.toString())
                Log.d("list-debug", "respon : " + respon?.logbooks.toString())

                adapter.setOnClickListener(object : LogbookAdapter.onClickListener {

                    override fun onItemClick(position: Int) {
                       val position =  respon?.logbooks?.get(position)
                        val sharedPref = getSharedPreferences("logbookpref", MODE_PRIVATE) ?: return
                        with (sharedPref.edit()) {
                            putString("IDL", position?.id.toString())
                            apply()
                        }
                        Log.d("Detail-update", position.toString())
                        val intent = Intent(this@ListLogbook, DetailLogbook::class.java)
//                        intent.putExtra("id_logbook", data[position].id)
//                detailLogbookIntent.putExtra("id_Extramagang",data[position].internshipId)
                        startActivity(intent)
                    }
                })
            }

        })

    }

}