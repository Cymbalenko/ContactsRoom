package com.example.contactsroom.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsroom.R
import com.example.contactsroom.ui.contactsList.ContactsListFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.fragments.isEmpty())
            addContactsFragment()
    }

    private fun addContactsFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactsListFragment.newInstance())
                .commit()
    }
}