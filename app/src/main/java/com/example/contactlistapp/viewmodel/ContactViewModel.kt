package com.example.contactlistapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactlistapp.model.ContactData
import com.example.contactlistapp.model.ContactList
import com.example.contactlistapp.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: ContactRepository): ViewModel() {

    private var contactList: MutableLiveData<ContactList> = MutableLiveData()

    fun getAllContactList(): LiveData<List<ContactData>>{
        return repository.getAllContact()
    }

    fun makeApiCall(){
        repository.getContact("q", contactList)
    }
}