package com.example.tourtravelfrontend

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tourtravelfrontend.databinding.ListDataPaketTravelBinding

class PaketTravelAdapter(
    private val listMahasiswa:ArrayList<PaketTravelData>,
    private val context: Context
): RecyclerView.Adapter<PaketTravelAdapter.PaketTravelViewHolder>() {
    inner class
    PaketTravelViewHolder(item: ListDataPaketTravelBinding): RecyclerView.ViewHolder(item.root){
        private val binding = item
        fun bind(mahasiswaData: PaketTravelData){
            with(binding) {
                txtNamapaket.text = mahasiswaData.namaPaket
                txtHarga.text = mahasiswaData.harga
                cvData.setOnClickListener {
                    var i = Intent(context,
                        DetailPaketTravelActivity::class.java).apply {
                        putExtra("nim",mahasiswaData.namaPaket)
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
        holder.bind(listMahasiswa[position])
    }
    override fun getItemCount(): Int = listMahasiswa.size
}