package com.example.contactlistapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.contactlistapp.databinding.ItemContactListBinding
import com.example.contactlistapp.model.ContactData
import dagger.hilt.android.internal.managers.FragmentComponentManager


class ContactListAdapter(
    private val context: Context,
    private var contactItems: List<ContactData>
) :
    RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder>() {

    fun setContactData(details: List<ContactData>) {
        this.contactItems = details
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val binding = ItemContactListBinding.inflate(LayoutInflater.from(context), parent, false)
        return ContactListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        holder.bind(contactItems[position])

    }

    override fun getItemCount(): Int {
        return contactItems.size
    }

    inner class ContactListViewHolder(private val binding: ItemContactListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ContactData) {
            binding.firstNameTitle.text = data.first_name
            binding.lastNameTitle.text = data.last_name
            binding.emailTitle.text = data.email
            Glide.with(context).load(data.avatar).into(binding.ivLogo)
        }
    }
}



