package com.example.tourtravelfrontend

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tourtravelfrontend.databinding.ActivityFormAddPaketTravelBinding

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FormAddPaketTravelActivity : AppCompatActivity() {
    private lateinit var binding :
            ActivityFormAddPaketTravelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityFormAddPaketTravelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener {
            saveData()
        }
    }
    fun saveData(){
        with(binding) {
            val namaPaket = txtNamapaket.text.toString()
            val tujuan = txtTujuan.text.toString()
            val asal = txtAsal.text.toString()
            val harga = txtHarga.text.toString()
            val jam = txtJam.text.toString()
            val durasi = txtDurasi.text.toString()

            RClient.instances.createDataPaketTravel(namaPaket,tujuan,asal,harga,jam,durasi).enqueue (object :
                Callback<ResponseCreate> {
                override fun onResponse(call: Call<ResponseCreate>, response: Response<ResponseCreate>) {
                    if(response.isSuccessful){
                        Toast.makeText(applicationContext,"${response.body()?.pesan}", Toast.LENGTH_LONG).show()
                        finish()
                    }else {
                        val jsonObj =
                            JSONObject(response.errorBody()!!.charStream().readText())

                        txtNamapaket.setError(jsonObj.getString("message"))
                        Toast.makeText(applicationContext,"Maaf sudah ada datanya", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<ResponseCreate>, t: Throwable) {
                }
            })
        }
    }
}