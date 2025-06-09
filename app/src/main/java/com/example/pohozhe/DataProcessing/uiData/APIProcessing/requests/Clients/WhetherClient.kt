package com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.Clients

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.pohozhe.DataProcessing.uiData.APIProcessing.requests.Interfaces.WeatherApiService

class UserAgentInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header(
                "User-Agent",
                "PohozheApp/1.0 grafgrei4@gmail.com"
            )
            .build()
        return chain.proceed(request)
    }
}

object WhetherClient {
    private const val BASE_URL = "https://api.met.no/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(UserAgentInterceptor())
        .build()

    val instance: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}
