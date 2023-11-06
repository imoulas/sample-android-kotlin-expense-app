package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var btn: Button = binding.toastButton
        btn.setOnClickListener {
            val random = java.util.Random()
            var randomNumber = 0
            randomNumber = random.nextInt(1000)

            // code behind my toast button
            var myToast = Toast.makeText(context, "Hello Isidoros! $randomNumber", Toast.LENGTH_SHORT)
            myToast.show()
        }

        var btnAbout: Button = binding.aboutButton
        btnAbout.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_aboutFragment)
        }

        var btnRandom: Button = binding.randomButton
        btnRandom.setOnClickListener {
            homeViewModel.generateRandom()
        }


        var btnNewExpense: Button = binding.expenseButton
        btnNewExpense.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_expenseFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}