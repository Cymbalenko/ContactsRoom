package com.example.contactsroom

import android.app.Application

class ContactsRoomApplication:Application() {

    companion object{
        var instance: ContactsRoomApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}