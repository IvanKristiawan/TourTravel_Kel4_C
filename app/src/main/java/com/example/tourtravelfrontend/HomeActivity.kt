package com.example.tourtravelfrontend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import com.example.tourtravelfrontend.databinding.ActivityHomeBinding
import com.example.tourtravelfrontend.fragment.DataPaketTravelFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showDataFragment()
        binding.btnAdd.setOnClickListener{
            startActivity(
                Intent(this,
                    FormAddPaketTravelActivity::class.java)
            )
        }
    }
    fun showDataFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataPaketTravelFragment()

//        val textCari = binding.txtCari.text
        val mBundle = Bundle()
//        mBundle.putString("cari", textCari.toString())
        mFragment.arguments = mBundle
        mFragmentTransaction.replace(R.id.fl_data, mFragment).commit()
    }
}