package com.app.cricapi

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.cricapi.adapter.MatchAdapter
import com.app.cricapi.model.Root
import com.app.cricapi.services.CricApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var btnGetNewMatches: Button? = null
    var retrofit: Retrofit? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        btnGetNewMatches = findViewById<Button>(R.id.btnGetNewMatches)

        btnGetNewMatches!!.setOnClickListener {
            Toast.makeText(this@MainActivity, "Getting data...", Toast.LENGTH_SHORT).show()
            retrofit = Retrofit.Builder()
                    .baseUrl("https://cricapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val apiServices = Retrofit.Builder()
                    .baseUrl("https://cricapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(CricApiServices::class.java)
            val call = apiServices.newMatches
            call.enqueue(object : Callback<Root?> {
                override fun onResponse(call: Call<Root?>, response: Response<Root?>) {
                    if (response.isSuccessful) {
                        val root = response.body()
                        val matchList = root!!.matches
                        val matchAdapter = MatchAdapter(this@MainActivity, matchList)
                        recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView!!.adapter = matchAdapter
                    } else {
                        Toast.makeText(this@MainActivity, response.code().toString() + " " + response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Root?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, """
     Something went wrong
     ${t.message}
     """.trimIndent(), Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}