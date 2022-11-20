package com.example.tourtravelfrontend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tourtravelfrontend.databinding.ActivityDetailPaketTravelBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPaketTravelActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailPaketTravelBinding
    private var b:Bundle? = null
    private val ListTravel = ArrayList<PaketTravelData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPaketTravelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        b = intent.extras
        val namaPaket = b?.getString("namaPaket")
        namaPaket?.let { getDataDetail(it) }
        binding.btnHapus.setOnClickListener {
            namaPaket?.let { it1 -> deleteData(it1) }
        }
        binding.btnEdit.setOnClickListener {
            startActivity(Intent(this, FormEditPaketTravelActivity::class.java).apply {
                putExtra("namaPaket",namaPaket)
            })
        }
    }
    fun getDataDetail(namaPaket:String){
        RClient.instances.getDataPaketTravel(namaPaket).enqueue(object :
            Callback<ResponseDataPaketTravel> {
            override fun onResponse(call: Call<ResponseDataPaketTravel>, response: Response<ResponseDataPaketTravel>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        ListTravel.addAll(it.data) }
                    with(binding) {
                        tvNamapaket.text = ListTravel[0].namaPaket
                        tvTujuan.text = ListTravel[0].tujuan
                        tvAsal.text = ListTravel[0].asal
                        tvHarga.text = ListTravel[0].harga
                        tvJam.text = ListTravel[0].jam
                        tvDurasi.text = ListTravel[0].durasi
                    }
                }
            }
            override fun onFailure(call:Call<ResponseDataPaketTravel>, t: Throwable) {
            }
        })
    }
    override fun onRestart() {
        super.onRestart()
        this.recreate()
    }
    fun deleteData(namaPaket:String){
        val builder =
            AlertDialog.Builder(this@DetailPaketTravelActivity)
        builder.setMessage("Anda Yakin mau hapus?? Saya ngga yakin loh.")
            .setCancelable(false)
            .setPositiveButton("Ya, Hapus Aja!"){dialog, id->
                doDeleteData(namaPaket)
            }
            .setNegativeButton("Tidak, Masih sayang dataku"){dialog,id -> dialog.dismiss()
            }
        val alert = builder.create()
        alert.show()
    }
    private fun doDeleteData(namaPaket:String) {
        RClient.instances.deleteData(namaPaket).enqueue(object :
            Callback<ResponseCreate>{
            override fun onResponse(call: Call<ResponseCreate>, response: Response<ResponseCreate>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "Data berhasil dihapus", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
            override fun onFailure(call: Call<ResponseCreate>, t:Throwable) {

            }
        })
    }
}