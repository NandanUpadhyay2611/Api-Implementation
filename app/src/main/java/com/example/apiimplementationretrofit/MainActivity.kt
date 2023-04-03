package com.example.apiimplementationretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdaPter: myAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


recyclerView=findViewById(R.id.recyclerView)
        val retrofitBuilder= Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiInterface::class.java)



        val retrofitData=  retrofitBuilder.getproductdata()

        retrofitData.enqueue(object:Callback<myData?>{

              // if api call is a success, then use the data of API and show in your app
              override fun onResponse(call: Call<myData?>, response: Response<myData?>) {
                 var responseBody=response.body()
                  val productlist= responseBody?.products!! //like this you can fetch whichever list or data you want from jsonfile used

      myAdaPter= myAdapter(this@MainActivity,productlist)
                  recyclerView.adapter=myAdaPter
                  recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
              }

              // if api call fails
              override fun onFailure(call: Call<myData?>, t: Throwable) {

                  //this way we can track the error in logcat
                  Log.d("MainActivity","onFailure: "+t.message)
              }


          }
        )
    }
}