package com.example.myapplication.ui.home

import android.os.Environment
import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File
import java.io.IOException

class ExpenseViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _expenseDate = MutableLiveData<String>().apply {
        value = ""
    }
    val expenseDate: MutableLiveData<String> = _expenseDate
    fun setExpenseDate(text: Editable) {
       _expenseDate.value = text.toString()
    }

    private val _expenseDescription = MutableLiveData<String>().apply {
        value = ""
    }
    val expenseDescription: MutableLiveData<String> = _expenseDescription
    fun setExpenseDescription(text: Editable) {
        _expenseDescription.value = text.toString()
    }

    private val _expenseMoney = MutableLiveData<String>().apply {
        value = ""
    }
    val expenseMoney: MutableLiveData<String> = _expenseMoney
    fun setExpenseMoney(text: Editable) {
        _expenseMoney.value = text.toString()
    }

    private val _expenseCategory = MutableLiveData<Int>().apply {
        value = 0
    }
    val expenseCategory: MutableLiveData<Int> = _expenseCategory
    fun setExpenseCategory(category: Int) {
        _expenseCategory.value = category
    }



    public fun SaveExpense() {
        var line:String = "${expenseDate.value},${expenseDescription.value},${expenseMoney.value},${expenseCategory.value}\n"

        //Log.e("test","${expenseDate.value},${expenseDescription.value},${expenseMoney.value},${expenseCategory.value}")

        //var test = expenseDate.value + "," + expenseDescription.value + "," + expenseMoney.value

        val path = Environment.getExternalStorageDirectory().absolutePath

        var fileName:String = "${path}${File.separator}Documents${File.separator}data.txt"
        //Log.e("Test", "${fileName}")

        try {
            var fileOut = File(fileName)
            fileOut.appendText(line)

        } catch ( e: IOException) {
            Log.e("Exception","File write failed: ${e}")
        }

    }
}