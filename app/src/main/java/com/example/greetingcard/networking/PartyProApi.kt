package com.example.greetingcard.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PartyProApi {
    private const val BASE_URL = "http://10.0.2.2:8080/"


    val vendorsApi: VendorInterface by lazy {
        val logging = HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        retrofit.create(VendorInterface::class.java)
    }
}