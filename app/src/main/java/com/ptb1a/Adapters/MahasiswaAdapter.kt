package com.ptb1a.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.databinding.ItemmahasiswaBinding
import com.ptb1a.models.InternshipsItem
import com.ptb1a.models.Mahasiswa

class MahasiswaAdapter (

    private var data: List<InternshipsItem>
    ):RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> () {

    private lateinit var MahasiswaListener: onClickListener

    fun setListMahasiswa(listMahasiswa: List<InternshipsItem>){
        this.data = listMahasiswa
        notifyDataSetChanged()
    }

    interface onClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onClickListener){
        MahasiswaListener = listener
    }

    inner class MahasiswaViewHolder(val itemBinding: ItemmahasiswaBinding ,listener: onClickListener) :RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: InternshipsItem) {
            itemBinding.tvNamaMahasiswa.text= data.name
            itemBinding.tvNIMMahasiswa.text= data.nim
            itemBinding.tvTempatKP.text= data.agency
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
