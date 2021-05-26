package com.example.contactsroom.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactsroom.model.db.dao.ContactsDao
import com.example.contactsroom.model.db.entity.ContactsEntity

@Database(
    entities = [ContactsEntity::class],
    version = 1
)
abstract class ContactsDataBase: RoomDatabase() {

    companion object {
        const val NAME = "contacts_db"
    }
    abstract val contactsDao: ContactsDao
}