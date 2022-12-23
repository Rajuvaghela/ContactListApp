package com.example.contactlistapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.contactlistapp.databinding.ActivityShowDetailContactBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShowDetailContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowDetailContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowDetailContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getContactData()

    }

    private fun getContactData() {
        binding.apply {
            firstNameDetail.text = intent.getStringExtra("firstName")
            lastNameDetail.text = intent.getStringExtra("lastName")
            emailDetail.text = intent.getStringExtra("email")
            val image = intent.getStringExtra("avatar")
            Glide.with(baseContext).load(image).into(ivLogoDetail)
        }
    }
}