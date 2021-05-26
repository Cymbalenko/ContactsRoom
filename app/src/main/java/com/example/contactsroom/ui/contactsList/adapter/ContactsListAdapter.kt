package com.example.contactsroom.ui.contactsList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsroom.R
import com.example.contactsroom.model.db.entity.ContactsEntity

class ContactsListAdapter (private val clickListener: (ContactsEntity) -> Unit
) : ListAdapter<ContactsEntity, ContactsListAdapter.ContactsViewHolder>(ContactDiffUtil()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ContactsViewHolder(view,clickListener)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        getItem(position).let { payment ->
            holder.bind(payment)
        }
    }

    class ContactsViewHolder(view: View, private val clickListener: (ContactsEntity) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bind(contact: ContactsEntity) {
            val textView = itemView.findViewById<TextView>(R.id.contact_name_text_view)

            textView.text = contact.name
            textView.setOnClickListener { clickListener(contact) }
        }

    }

    class ContactDiffUtil: DiffUtil.ItemCallback<ContactsEntity>(){
        override fun areItemsTheSame(oldItem: ContactsEntity, newItem: ContactsEntity): Boolean {
            return  oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactsEntity, newItem: ContactsEntity): Boolean {
            return  oldItem==newItem
        }

    }


}