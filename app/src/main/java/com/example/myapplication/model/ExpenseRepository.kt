package com.example.myapplication.model


class ExpenseRepository {

    data class Expense(val Date: String,
                       val Money:String,
                       val Category:Int,
                       val Description:String )
    fun getExpenseData(): Expense {
        // todo: return expense models (not one only)
        // Fetch expense file

        // for each
        // add model

        //return models

        return Expense( Date = "12/12/2023", Money = "123.45", Category = 1, Description = "Hello world")
    }
}