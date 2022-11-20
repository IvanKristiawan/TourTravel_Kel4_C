package com.example.tourtravelfrontend.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourtravelfrontend.*
import com.example.tourtravelfrontend.databinding.FragmentDataPaketTravelBinding
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataPaketTravelFragment : Fragment() {
    private var _binding: FragmentDataPaketTravelBinding? = null

    private val binding get() = _binding!!
    private val ListTravel = ArrayList<PaketTravelData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataPaketTravelBinding.inflate(inflater,
            container, false)
        return binding.root
        getDataPaketTravel()
    }

    override fun onStart() {
        super.onStart()
        getDataPaketTravel()
    }

    private fun getDataPaketTravel() {
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager=LinearLayoutManager(context)
        val bundle = arguments
        val cari = bundle?.getString(/* key = */ "cari")
        binding.progressBar.visibility
        RClient.instances.getDataPaketTravel(cari).enqueue(object :
            Callback<ResponseDataPaketTravel>{
            override fun onResponse(
                call: Call<ResponseDataPaketTravel>,
                response: Response<ResponseDataPaketTravel>){
                if (response.isSuccessful){
                    ListTravel.clear()
                    response.body()?.let {
                        ListTravel.addAll(it.data) }
                    val adapter =
                        PaketTravelAdapter(ListTravel, requireContext())
                    binding.rvData.adapter = adapter
//                    Log.e("TAG", "response 123456: " + Gson().toJson(listMahasiswa))
                    adapter.notifyDataSetChanged()
                    binding.progressBar.isVisible = false
                }
            }
            override fun onFailure(call: Call<ResponseDataPaketTravel>, t:
            Throwable) {
            }
        }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}