package com.example.retrofitassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitassignment.adapter.PostAdapter
import com.example.retrofitassignment.api.TypicodeApiInterface
import com.example.retrofitassignment.model.Typicode
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPost()
    }

    fun loadTypiCodeList(postList: List<Typicode>) {
        recyclerPost.apply {
            layoutManager = LinearLayoutManager(context)
            val postAdapter = PostAdapter(postList, context)
            adapter = postAdapter
        }
    }

        fun getPost() {

            var BASE_URL = "https://jsonplaceholder.typicode.com/"

            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            var retrofitService = retrofit.create(TypicodeApiInterface::class.java)

            var apiCall = retrofitService.getPost()

            apiCall.enqueue(object :
                Callback<List<Typicode>> {
                override fun onFailure(call: Call<List<Typicode>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<List<Typicode>>,
                    response: Response<List<Typicode>>
                ) {
                    var postList = response.body()
                    Log.d("Response>>>>>", postList.toString())

                    if (postList != null) {
                        loadTypiCodeList(postList)
                    }
                }


            })
        }
}
