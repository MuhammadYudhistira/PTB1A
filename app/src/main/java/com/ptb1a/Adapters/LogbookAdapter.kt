package com.ptb1a.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.PojoModels.LogbookItem
import com.ptb1a.databinding.ItemlogbookBinding

class LogbookAdapter():
    RecyclerView.Adapter<LogbookAdapter.LogbookViewHolder> () {


    private lateinit var logbookListener: clickListener

    var listLogbook: List<LogbookItem> = ArrayList()

    fun setlistLogbook(listLogbook: List<LogbookItem>){
            this.listLogbook = listLogbook
            notifyDataSetChanged()
        }

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        logbookListener = listener
    }

    inner class LogbookViewHolder(val itemBinding: ItemlogbookBinding, listener: clickListener):RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogbookViewHolder {
        return  LogbookViewHolder(ItemlogbookBinding.inflate(LayoutInflater.from(parent.context), parent, false), logbookListener)
    }

    override fun getItemCount(): Int {
        return listLogbook.size
    }

    override fun onBindViewHolder(holder: LogbookViewHolder, position: Int) {
        val item : LogbookItem = listLogbook.get(position)
        holder.itemBinding.tvJudul.text = item.activities
        holder.itemBinding.tvTanggal.text = item.date
    }

}

