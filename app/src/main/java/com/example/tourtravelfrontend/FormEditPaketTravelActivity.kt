package com.example.tourtravelfrontend

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tourtravelfrontend.databinding.ActivityFormEditPaketTravelBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.*
import kotlin.collections.ArrayList

class FormEditPaketTravelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFormEditPaketTravelBinding
    private var b:Bundle? = null
    private val ListTravel = ArrayList<PaketTravelData>()
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormEditPaketTravelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Form Edit Paket Travel"
        b = intent.extras
        val namaPaket = b?.getString("namaPaket")
        namaPaket?.let { getDetailData(it) }
        binding.btnUpdate.setOnClickListener {
            with(binding) {
                val namaPaket = txtNamapaket.text.toString()
                val tujuan = txtTujuan.text.toString()
                val asal = txtAsal.text.toString()
                val harga = txtHarga.text.toString()
                val jam = txtJam.text.toString()
                val durasi = txtDurasi.text.toString()

                RClient.instances.updateDataPaketTravel(namaPaket,tujuan,asal,harga,jam,durasi).enqueue(object : Callback<ResponseCreate> {
                    override fun onResponse(
                        call: Call<ResponseCreate>,
                        response: Response<ResponseCreate>
                    ) {
                        if(response.isSuccessful) {

                            Toast.makeText(applicationContext,"${response.body()?.pesan}",
                                Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
                    override fun onFailure(call:Call<ResponseCreate>, t: Throwable) {

                    }
                })
            }
        }
    }
    fun getDetailData(namaPaket:String) {
        RClient.instances.getDataPaketTravel(namaPaket).enqueue(object :
            Callback<ResponseDataPaketTravel> {
            override fun onResponse(
                call: Call<ResponseDataPaketTravel>,
                response: Response<ResponseDataPaketTravel>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        ListTravel.addAll(it.data) }
                    with(binding) {
                        txtNamapaket.setText(ListTravel[0].namaPaket)

                        txtTujuan.setText(ListTravel[0].tujuan)

                        txtAsal.setText(ListTravel[0].asal)

                        txtHarga.setText(ListTravel[0].harga)

                        txtJam.setText(ListTravel[0].jam)

                        txtDurasi.setText(ListTravel[0].durasi)
                    }
                }
            }
            override fun onFailure(call: Call<ResponseDataPaketTravel>, t: Throwable) {
            }
        })
    }
}