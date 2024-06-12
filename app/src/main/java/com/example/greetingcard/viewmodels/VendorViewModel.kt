package com.example.greetingcard.viewmodels

import android.provider.Telephony.Mms.Part
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greetingcard.models.Vendor
import com.example.greetingcard.networking.PartyProApi
import kotlinx.coroutines.launch

class VendorViewModel : ViewModel() {

    private val _vendors = MutableLiveData<List<Vendor>>()
    val vendors: LiveData<List<Vendor>> = _vendors

    private val _selectedFilter = MutableLiveData<String>()
    val selectedFilter: LiveData<String> = _selectedFilter

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

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
        viewModelScope.launch {
            try {
                val response = PartyProApi.vendorsApi.getVendorBySearchQuery(query)
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

        fun setSelectedFilter(filter: String) {
            _selectedFilter.value = filter
            if (filter.isEmpty()) {
                getVendors()
            } else {
                getVendorsByType(filter)
            }
        }

        fun setSearchQuery(query: String) {
            _searchQuery.value = query
            if (query.isEmpty()) {
                getVendors()
            } else {
                getVendorBySearchQuery(query)
            }
        }
    }

