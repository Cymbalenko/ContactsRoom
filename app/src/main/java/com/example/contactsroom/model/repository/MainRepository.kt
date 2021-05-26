package com.example.contactsroom.model.repository

import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.contactsroom.ContactsRoomApplication
import com.example.contactsroom.model.db.entity.ContactsEntity
import com.example.contactsroom.model.db.ContactsDataBase
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

object  MainRepository {
   private val db: ContactsDataBase =createDataBase()


    fun insertContact(contacts: ContactsEntity) : Single<Long>{
        return db.contactsDao.insert(contacts)
    }

    fun getAllContactsAsLiveData(): LiveData<List<ContactsEntity>>{
        return db.contactsDao.getAllContacts()
    }

    private fun createDataBase(): ContactsDataBase {
        return Room.databaseBuilder(
            ContactsRoomApplication.instance!!,
            ContactsDataBase::class.java,
            ContactsDataBase.NAME
        ).build()
    }

    fun update(contact: ContactsEntity): Completable  {
        return db.contactsDao.update(contact)
    }

    fun deleteById(id: Int): Completable  {
        return db.contactsDao.deleteById(id)
    }

    fun getAllContacts(): LiveData<List<ContactsEntity>> {
        return db.contactsDao.getAllContacts()
    }

    fun getContactById(id: Int): Single<List<ContactsEntity>> {
        return db.contactsDao.getContactById(id)
    }
}