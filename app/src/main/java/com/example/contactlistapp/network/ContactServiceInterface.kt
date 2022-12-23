package com.example.contactlistapp.network

import com.example.contactlistapp.model.ContactList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactServiceInterface {

    @GET("/api/users?page=2")
    fun getDataFromAPI(@Query("q")query: String): Call<ContactList>
}