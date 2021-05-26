package com.example.contactsroom.ui.contactsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.contactsroom.model.db.entity.ContactsEntity
import com.example.contactsroom.model.repository.MainRepository

class ContactsListViewModel : ViewModel() {
    val contacts: LiveData<List<ContactsEntity>> = MainRepository.getAllContactsAsLiveData()
}