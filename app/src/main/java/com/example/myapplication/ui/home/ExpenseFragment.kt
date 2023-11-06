package com.example.myapplication.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentExpenseBinding

class ExpenseFragment : Fragment() {

    private var _binding: FragmentExpenseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val expenseViewModel =
            ViewModelProvider(this).get(ExpenseViewModel::class.java)

        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var btnSave: Button = binding.saveButton
        btnSave.setOnClickListener {

            expenseViewModel.setExpenseDate( binding.expenseDate.text )
            expenseViewModel.setExpenseDescription( binding.expenseDescription.text )
            expenseViewModel.setExpenseMoney( binding.expenseMoney.text )

            var category:Int = 0
            if( binding.personalRadiobutton.isChecked ) {
                category = 1
            }
            if( binding.supermarketRadiobutton.isChecked ) {
                category = 2
            }
            if( binding.gasRadiobutton.isChecked ) {
                category = 3
            }
            if( binding.commonRadiobutton.isChecked ) {
                category = 4
            }
            expenseViewModel.setExpenseCategory( category )

            // todo: save expense
            expenseViewModel.SaveExpense()

            findNavController().popBackStack()
        }

        return root
    }

}