package com.example.contactlistapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactlistapp.model.ContactData

@Database(entities = [ContactData::class], version = 1, exportSchema = false)
abstract class ContactAppDataBase : RoomDatabase(){

    abstract fun getContactAppDao(): ContactDao

    companion object{
        private var DB_INSTANCE: ContactAppDataBase? = null

        fun getContactAppInstance(context: Context): ContactAppDataBase{
            if (DB_INSTANCE == null){
                DB_INSTANCE = Room.databaseBuilder(context.applicationContext, ContactAppDataBase::class.java, "CONTACTAPP_DB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}