package com.example.greetingcard.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.VNode
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greetingcard.models.Vendor
import com.example.greetingcard.networking.PartyProApi
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch

class VendorViewModel : ViewModel() {

    private val _vendors = MutableLiveData<List<Vendor>>()
    val vendors: LiveData<List<Vendor>> = _vendors

    private val _selectedFilter = MutableLiveData<String>()
    val selectedFilter: LiveData<String> = _selectedFilter

    private val _searchResults = MutableLiveData<String?>(null)
    val searchResults: LiveData<String?> = _searchResults

    private val _selectedVendor = MutableLiveData<Vendor>(null)
    val selectedVendor: LiveData<Vendor> = _selectedVendor


    init {
        getVendors()
    }

    fun getVendors() {
        viewModelScope.launch {
            try {
                val response = PartyProApi.vendorsApi.getVendors()
                if (response.isNotEmpty()) {
                    _vendors.value = response
                } else {
                    Log.d("VendorViewModel", "No vendors found")
                }
            } catch (e: Exception) {
                // Handle errors here
                e.printStackTrace()
            }
        }
    }

    fun getVendorsByType(type: String) {
        viewModelScope.launch {
            try {
                val response = PartyProApi.vendorsApi.getVendorsByType(type)
                if (response.isNotEmpty()) {
                    _vendors.value = response
                } else {
                    Log.d("VendorViewModel", "No vendors found by type")
                }
            } catch (e: Exception) {
                // Handle errors here
                e.printStackTrace()
            }
        }
    }

    fun getVendorBySearchQuery(query: String) {
        Log.d("query", query)
        viewModelScope.launch {
            try {
                val searchObject = SearchObject(query)
                val response = PartyProApi.vendorsApi.getVendorBySearchQuery(searchObject)
                if (response.isNotEmpty()) {
                    _vendors.value = response
                } else {
                    Log.d("VendorViewModel", "No vendors found")
                }
            } catch (e: Exception) {
                // Handle errors here
                e.printStackTrace()
            }
        }
    }


    data class SearchObject(
        @SerializedName("searchQuery") val searchQuery: String
    )



    fun setSelectedFilter(filter: String) {
        _selectedFilter.value = filter
        if (filter.isEmpty()) {
            getVendors()
        } else {
            getVendorsByType(filter)
        }
    }

    fun setSelectedVendor(selectedVendor: Vendor){
        _selectedVendor.value = selectedVendor
//        getVendorById(selectedVendor.id)
    }

}

