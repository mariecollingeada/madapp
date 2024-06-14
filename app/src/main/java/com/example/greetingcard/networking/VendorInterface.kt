package com.example.greetingcard.networking

import com.example.greetingcard.models.Vendor
import com.example.greetingcard.viewmodels.VendorViewModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VendorInterface {
    @GET("/api/vendor")
    suspend fun getVendors() : List<Vendor>

    @GET("/api/vendor/filter/vendorType/{vendorType}")
    suspend fun getVendorsByType(@Path("vendorType") type: String): List<Vendor>

    @POST("/api/vendor/filter/search")
    suspend fun getVendorBySearchQuery(@Body query: VendorViewModel.SearchObject): List<Vendor>

    @GET("/api/vendor/{id}")
    suspend fun getVendorById(@Path("id") type: Int): List<Vendor>
}