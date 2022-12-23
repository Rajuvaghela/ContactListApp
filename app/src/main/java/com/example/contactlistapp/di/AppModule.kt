package com.example.contactlistapp.di

import android.app.Application
import android.content.Context
import com.example.contactlistapp.database.ContactAppDataBase
import com.example.contactlistapp.database.ContactDao
import com.example.contactlistapp.network.ContactServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val BASE_URL = "https://reqres.in/"

    @Provides
    @Singleton
    fun getRetrofitServiceInstance(retrofit: Retrofit) : ContactServiceInterface {
        return retrofit.create(ContactServiceInterface::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getContactAppDatabase(context: Application): ContactAppDataBase{
        return ContactAppDataBase.getContactAppInstance(context)
    }

    @Provides
    @Singleton
    fun getContactDao(contactAppDataBase: ContactAppDataBase): ContactDao{
        return contactAppDataBase.getContactAppDao()
    }
}