package com.example.contactlistapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactlistapp.model.ContactData

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts_data ORDER BY id DESC")
    fun getAllContact() : LiveData<List<ContactData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contactData: ContactData)

}