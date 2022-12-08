package com.globe.textviewgetapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.globe.gapps.parking.ParkingSlotAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    // on below line we are creating variables for
    // our text view, image view and progress bar
    lateinit var courseNameTV: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var visitCourseBtn: Button
    private val parkingSlotAdapter = ParkingSlotAdapter()
    private val slots: ArrayList<CourseDataModalMain> = ArrayList()
    //lateinit var loadingPB: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // on below line we are initializing our variable with their ids.
        courseNameTV = findViewById(R.id.textView)

        recyclerView = findViewById(R.id.rvSlots)
        // on below line we are creating a method
        // to get data from api using retrofit.
        getData()



    }

    private fun getData() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        parkingSlotAdapter.onItemClickListener = object : OnItemClickListener {
            override fun onItemClicked(position: Int) {
                val selectedslot = parkingSlotAdapter.slots.get(position)
                //slotsDetail(position)
                Log.d("ParkingActivity", "$selectedslot")
            }
        }
        // on below line we are creating a retrofit
        // builder and passing our base url
        // on below line we are creating a retrofit
        // builder and passing our base url
        val retrofit = Retrofit.Builder()
            .baseUrl("https://zh66xn42vk.execute-api.ap-southeast-1.amazonaws.com/stage/")

            // on below line we are calling add Converter
            // factory as GSON converter factory.
            // at last we are building our retrofit builder.
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // below line is to create an instance for our retrofit api class.
        // below line is to create an instance for our retrofit api class.
        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

        val call: Call<CourseDataModal?>? = retrofitAPI.getAll()

        // on below line we are making a call.
        call!!.enqueue(object : Callback<CourseDataModal?> {
            override fun onResponse(
                call: Call<CourseDataModal?>?,
                response: Response<CourseDataModal?>
            ) {
                if (response.isSuccessful()) {

                    val areas: List<CourseDataModalMain> = response.body()!!.ParkingAreas
                    Log.d("Main", "${areas}")
                    for (x in areas) {
                        slots.add(CourseDataModalMain("${x.parkingArea}","${x.parkingAddress}",x.slots))
                    }
                    parkingSlotAdapter.slots = slots
                    recyclerView.adapter = parkingSlotAdapter

                }
            }

            override fun onFailure(call: Call<CourseDataModal?>?, t: Throwable?) {
                // displaying an error message in toast
                Toast.makeText(this@MainActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}