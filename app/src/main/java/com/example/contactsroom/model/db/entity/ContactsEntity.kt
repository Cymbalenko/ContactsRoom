package com.example.contactsroom.model.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactsEntity (
    val name: String,
    val number: Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
