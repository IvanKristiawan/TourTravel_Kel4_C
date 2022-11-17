package com.example.tourtravelfrontend

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tourtravelfrontend.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding :
            ActivityMainBinding
    private lateinit var mainLayout:ConstraintLayout
    private val listUser = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            saveData()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
        setTitle("User Login")

        mainLayout = findViewById(R.id.mainLayout)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
    fun saveData(){
        with(binding) {
            val email = txtEmail.text.toString()
            val password = txtPassword.text.toString()

//            RClient.instances.getUserEmail(email).enqueue(object :
//                Callback<ResponseDataUser> {
//                override fun onResponse(call: Call<ResponseDataUser>, response: Response<ResponseDataUser>) {
//                    if(response.isSuccessful){
//                        response.body()?.let {
//                            listUser.addAll(it.data) }
//                        with(binding) {
//                            tvNim.text = listUser[0].username
////                                        tvNama.text = listMahasiswa[0].nama
////                                        tvAlamat.text = listMahasiswa[0].alamat
////                                        tvProdi.text = listMahasiswa[0].prodi
////                                        tvTgllahir.text = listMahasiswa[0].tgllhr
//                        }
//                        Toast.makeText(applicationContext,"${listUser[0].username}", Toast.LENGTH_LONG).show()
//                        finish()
//                        Log.e("TAG", "response 33: " + Gson().toJson(listUser[0].username))
//                    }
//                }
//                override fun onFailure(call:Call<ResponseDataUser>, t: Throwable) {
//                }
//            })

//            RClient.instances.loginData(email,password).enqueue (object :
//                Callback<ResponseCreate> {
//                override fun onResponse(call: Call<ResponseCreate>, response: Response<ResponseCreate>) {
//                    if(response.isSuccessful){
////                        Toast.makeText(applicationContext,"${response.body()}", Toast.LENGTH_LONG).show()
////                        finish()
//                    }else {
//                        val jsonObj =
//                            JSONObject(response.errorBody()!!.charStream().readText())
//
//                        txtEmail.setError(jsonObj.getString("message"))
//                        Toast.makeText(applicationContext,"Maaf sudah ada datanya", Toast.LENGTH_LONG).show()
//                    }
//                }
//                override fun onFailure(call: Call<ResponseCreate>, t: Throwable) {
//                }
//            })
        }
    }
}