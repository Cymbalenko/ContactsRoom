package com.example.contactsroom.model.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contactsroom.model.db.entity.ContactsEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface ContactsDao {

    @Insert
    fun insert(contact: ContactsEntity): Single<Long>

    @Update
    fun update(contact: ContactsEntity): Completable

    @Query("DELETE FROM ContactsEntity WHERE id = :id")
    fun deleteById(id: Int): Completable

    @Query("SELECT * FROM ContactsEntity")
    fun getAllContacts(): LiveData<List<ContactsEntity>>

    @Query("SELECT * FROM ContactsEntity WHERE id = :id")
    fun getContactById(id: Int): Single<List<ContactsEntity>>
}