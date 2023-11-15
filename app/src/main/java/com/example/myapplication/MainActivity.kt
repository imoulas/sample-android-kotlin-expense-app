package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var incomeEditText:EditText
    private lateinit var submitIncomeButton:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        incomeEditText = findViewById(R.id.incomeEditText)
        submitIncomeButton = findViewById(R.id.submitIncomeButton)
        submitIncomeButton.setOnClickListener {
            recordIncome()
        }

    fun recordIncome() {
        val incomeText = incomeEditText.text.toString()
        if (incomeText.isNotEmpty()) {
            val incomeAmount = incomeText.toDouble()
            Toast.makeText(this, "Income recorded: $incomeAmount", Toast.LENGTH_SHORT).show()
            incomeEditText.text.clear()
        } else{
                Toast.makeText(this,"Please enter a valid income amount ",Toast.LENGTH_SHORT).show()
            }

    }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun recordIncome() {
        TODO("Not yet implemented")
    }
}