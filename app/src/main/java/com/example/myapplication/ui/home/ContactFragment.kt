package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
     private var _binding :FragmentContactBinding? = null
     private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val ContactViewModel =
            ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

       var btnContact: Button =binding.contactButton
        btnContact.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_contact_to_addContactFragment2)
        }

        val contactContent = ContactViewModel.ReadContacts()

        val textView: TextView = binding.textContact
        textView.text = contactContent

        return root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}