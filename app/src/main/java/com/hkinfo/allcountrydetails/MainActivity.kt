package com.hkinfo.allcountrydetails

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hkinfo.allcountrydetails.API.ApiClient
import com.hkinfo.allcountrydetails.API.ApiInterface
import com.hkinfo.allcountrydetails.Adapter.CountryAdapter
import com.hkinfo.allcountrydetails.Model.CountryModal
import com.hkinfo.allcountrydetails.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var page = 1
    lateinit var binding : ActivityMainBinding
    var adapter = CountryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        callApi()
    }

    private fun callApi() {

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiInterface.getCountry().enqueue(object : Callback<List<CountryModal>>{
            override fun onResponse(
                call: Call<List<CountryModal>>,
                response: Response<List<CountryModal>>
            ) {

                var list = response.body() as ArrayList<CountryModal>

                if(response.isSuccessful){
                    var clickItem = object : CountryClick {
                        override fun onTap(i: Int) {
                            startActivity(Intent(this@MainActivity,CountryDetails::class.java).putExtra("pos",i))
                        }
                    }

                    for (l in list!!){
                        Log.e(TAG,"onResponse: -------------"+l.name)
                    }
                    adapter.setList(list)
                    binding.rcvCountry.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rcvCountry.adapter = CountryAdapter(list,clickItem)
                }
            }

            override fun onFailure(call: Call<List<CountryModal>>, t: Throwable) {

            }

        })
    }
}