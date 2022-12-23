package com.example.contactlistapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlistapp.adapter.ContactListAdapter
import com.example.contactlistapp.databinding.ActivityMainBinding
import com.example.contactlistapp.viewmodel.ContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contactListAdapter: ContactListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this)[ContactViewModel::class.java]
        viewModel.getAllContactList().observe(this) {
            binding.apply {
                if (it != null) {
                    rvContactList.layoutManager = LinearLayoutManager(this@MainActivity)
                    rvContactList.setHasFixedSize(true)
                    contactListAdapter = ContactListAdapter(baseContext, it)
                    rvContactList.adapter = contactListAdapter
                    contactListAdapter.setContactData(it)
                    contactListAdapter.notifyDataSetChanged()
                }
            }
        }
        viewModel.makeApiCall()
    }
}
