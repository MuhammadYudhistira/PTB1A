package com.ptb1a.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ptb1a.R
import com.ptb1a.models.Logbook

class LogbookAdapter (
    private val data: ArrayList<Logbook>
): RecyclerView.Adapter<LogbookAdapter.LogbookViewHolder> () {

    private lateinit var logbookListener: clickListener

    interface clickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: clickListener) {
        logbookListener = listener
    }

    inner class LogbookViewHolder(itemView: View, listener: clickListener):RecyclerView.ViewHolder(itemView) {
        private val Judul: TextView = itemView.findViewById(R.id.tvJudul)
        private val Tanggal: TextView = itemView.findViewById(R.id.tvTanggal)

        fun bind(data: Logbook) {
            Judul.text = data.judul
            Tanggal.text = data.tanggal
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogbookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlogbook, parent, false)
        return LogbookViewHolder(view, logbookListener)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LogbookViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

