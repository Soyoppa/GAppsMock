package com.globe.textviewgetapi

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    // as we are making get request
    // so we are displaying GET as annotation.
    // and inside we are passing
    // last parameter for our url.
    @GET("https://zh66xn42vk.execute-api.ap-southeast-1.amazonaws.com/stage/parkingareas")
    fun getAll(): Call<CourseDataModal?>?

    @GET("https://zh66xn42vk.execute-api.ap-southeast-1.amazonaws.com/stage/parkingarea?parkingArea=three%20parkade")
    fun getOne(): Call<CourseDataModal?>?
}