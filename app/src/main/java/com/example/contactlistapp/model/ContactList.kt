package com.example.contactlistapp.model

data class ContactList(
    val data: List<ContactData>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)