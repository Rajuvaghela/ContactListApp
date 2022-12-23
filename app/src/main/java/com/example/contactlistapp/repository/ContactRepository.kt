package com.example.contactlistapp.repository

import retrofit2.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactlistapp.database.ContactDao
import com.example.contactlistapp.model.ContactData
import com.example.contactlistapp.model.ContactList
import com.example.contactlistapp.network.ContactServiceInterface
import retrofit2.Response
import javax.inject.Inject
import retrofit2.Callback

class ContactRepository @Inject constructor(
    private val contactServiceInterface: ContactServiceInterface,
    private val contactDao: ContactDao) {

    fun getAllContact(): LiveData<List<ContactData>> {
        return contactDao.getAllContact()
    }

    fun insertContact(contactData: ContactData) {
        contactDao.insertContact(contactData)
    }

    fun getContact(query: String, contactList: MutableLiveData<ContactList>) {
        val call: Call<ContactList> = contactServiceInterface.getDataFromAPI(query)
        call.enqueue(object : Callback<ContactList> {
            override fun onResponse(call: Call<ContactList>, response: Response<ContactList>) {
                if (response.isSuccessful) {
                    response.body()?.data?.forEach {
                        insertContact(it)
                    }
                }
            }

            override fun onFailure(call: Call<ContactList>, t: Throwable) {

            }
        })
    }
}
