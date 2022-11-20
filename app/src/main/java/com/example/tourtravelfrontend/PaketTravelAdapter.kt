package com.example.tourtravelfrontend

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tourtravelfrontend.databinding.ListDataPaketTravelBinding

class PaketTravelAdapter(
    private val ListTravel:ArrayList<PaketTravelData>,
    private val context: Context
): RecyclerView.Adapter<PaketTravelAdapter.PaketTravelViewHolder>() {

    inner class PaketTravelViewHolder(item: ListDataPaketTravelBinding)
        : RecyclerView.ViewHolder(item.root){
        private val binding = item
        fun bind(TravelData: PaketTravelData){
            with(binding) {
                txtNamapaket.text = TravelData.namaPaket
                txtHarga.text = TravelData.tujuan

                cvData.setOnClickListener {
                    var i = Intent(context,
                        DetailPaketTravelActivity::class.java).apply {
                        putExtra("namaPaket",TravelData.namaPaket)
                    }
                    context.startActivity(i)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): PaketTravelViewHolder {
        return PaketTravelViewHolder(ListDataPaketTravelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        ))
    }
    override fun onBindViewHolder(holder: PaketTravelViewHolder,
                                  position: Int) {
        holder.bind(ListTravel[position])
    }
    override fun getItemCount(): Int = ListTravel.size
}