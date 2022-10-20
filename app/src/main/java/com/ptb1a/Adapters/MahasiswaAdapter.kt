package com.ptb1a.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.R
import com.ptb1a.models.Mahasiswa

class MahasiswaAdapter (
    private val data: ArrayList<Mahasiswa>
    ):RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> () {

    private lateinit var MahasiswaListener: onClickListener

    interface onClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onClickListener){
        MahasiswaListener = listener
    }

    class MahasiswaViewHolder(ItemView: View, listener: onClickListener):RecyclerView.ViewHolder(ItemView) {

        private val Nama: TextView = itemView.findViewById(R.id.tvNama)
        private val Nim: TextView = itemView.findViewById(R.id.tvNIM)
        private val Tempat: TextView = itemView.findViewById(R.id.tvTempat)
//        private val fotoprofil: ImageView = itemView.findViewById(R.id.ProfilMahasiswa)

        fun bind(data: Mahasiswa) {
            Nama.text = data.Nama
            Nim.text = data.Nim
            Tempat.text = data.Tempat
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itemmahasiswa, parent, false)
        return MahasiswaViewHolder(view, MahasiswaListener)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
