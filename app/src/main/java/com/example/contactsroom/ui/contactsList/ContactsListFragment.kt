package com.example.contactsroom.ui.contactsList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsroom.R
import com.example.contactsroom.model.db.entity.ContactsEntity
import com.example.contactsroom.ui.contact.ContactCreateEditFragment
import com.example.contactsroom.ui.contactsList.adapter.ContactsListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ContactsListFragment  : Fragment(){

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel:ContactsListViewModel by viewModels()
    private val adapter = ContactsListAdapter { contact ->
        goToCreateEditFragment(contact)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contacts_list_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView(view)
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { goToCreateEditFragment() }
        viewModel.contacts.observe(viewLifecycleOwner) { contacts ->
            adapter.submitList(contacts)
        }
    }

    private fun setUpRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun goToCreateEditFragment(contact: ContactsEntity? = null) {
        val contactCreateEditFragment = ContactCreateEditFragment.newInstance(contact?.id ?: -1)

        parentFragmentManager.beginTransaction()
                .replace(R.id.container, contactCreateEditFragment)
                .addToBackStack(null)
                .commit()
    }
}