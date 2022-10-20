package com.ptb1a.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.databinding.ItemmahasiswaBinding
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

    inner class MahasiswaViewHolder(val itemBinding: ItemmahasiswaBinding ,listener: onClickListener):RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: Mahasiswa) {
            itemBinding.tvNamaMahasiswa.text= data.Nama
            itemBinding.tvNIMMahasiswa.text= data.Nim
            itemBinding.tvTempatKP.text= data.Tempat
        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        return MahasiswaViewHolder(ItemmahasiswaBinding.inflate(LayoutInflater.from(parent.context), parent,false), MahasiswaListener)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
