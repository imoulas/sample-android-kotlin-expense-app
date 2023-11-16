package com.example.myapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddContactBinding
import com.example.myapplication.databinding.FragmentExpenseBinding

class AddContactFragment : Fragment() {

    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val addContactViewModel =
            ViewModelProvider(this).get(AddContactViewModel::class.java)

        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var btnAdd: Button = binding.addButton
        btnAdd.setOnClickListener {

            addContactViewModel.setName( binding.contactName.text )


            addContactViewModel.SaveContact()

            findNavController().popBackStack()
        }

        return root
    }


}