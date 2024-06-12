package com.example.greetingcard.networking

import com.example.greetingcard.models.Vendor
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface VendorInterface {
    @GET("/api/vendor")
    suspend fun getVendors() : List<Vendor>

    @GET("/api/vendor/filter/vendorType/{vendorType}")
    suspend fun getVendorsByType(@Path("vendorType") type: String): List<Vendor>

    @POST("/filter/search")
    suspend fun getVendorBySearchQuery(@Query("query") query: String): List<Vendor>
}