    package com.example.uts

    import android.os.Bundle
    import android.util.Log
    import androidx.appcompat.app.AppCompatActivity
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            val apiService = ApiClient.retrofit.create(ApiService::class.java)
            val call = apiService.getAllCardData()

            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful) {
                        val apiResponse = response.body()
                        val cardList = apiResponse?.data ?: emptyList()

                        // Set adapter with cardList
                        recyclerView.adapter = CardAdapter(cardList)
                    } else {
                        Log.e("API Error", "Response error: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.e("API Error", "Failure: ${t.message}")
                }
            })
        }

    }
