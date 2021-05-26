package com.example.contactsroom.ui.contact

import android.util.Log
import android.util.Log.INFO
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.contactsroom.model.db.entity.ContactsEntity
import com.example.contactsroom.model.repository.MainRepository
import com.example.contactsroom.ui.BaseViewModel
import java.util.logging.Level.INFO

class ContactCreateEditViewModel : BaseViewModel() {

    private val _editedContact = MutableLiveData<ContactsEntity>()

    val editedContact: LiveData<ContactsEntity> = _editedContact

    fun setEditedContactId(id: Int) {
        if (id != -1 && _editedContact.value == null) {
            disposeOnCleared(
                    MainRepository.getContactById(id),
                    { contactAsList ->
                        _editedContact.value = contactAsList.singleOrNull()
                    }, {
                // handle error
            }
            )
        }
    }

    fun save(name: String, number: String) {
        val editedContact = _editedContact.value
        if (editedContact == null) { // edit mode
            val contactToInsert = ContactsEntity(name, number.toIntOrNull() ?: 0)
            disposeOnCleared(
                    MainRepository.insertContact(contactToInsert),
                    { id ->
                        Log.d("id",id.toString())
                        // hLoandle success
                    }, {
                // handle error
            }
            )
        } else { // create mode
            val contactToUpdate = ContactsEntity(name, number.toIntOrNull() ?: 0)
            contactToUpdate.id = editedContact.id

            disposeOnCleared(
                    MainRepository.update(contactToUpdate),
                    {
                        // handle success
                    }, {
                // handle error
            }
            )
        }


    }
}