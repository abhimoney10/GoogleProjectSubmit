package com.abhishek.googledemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExpenseViewModal (application: Application) : AndroidViewModel(application) {

    private val repository: ExpenseDataRepository
   val allexpense: LiveData<List<Expenses>>

    init {
        val expenseDao = ExpensDataBase.getDatabase(application).expensDao()
        repository = ExpenseDataRepository(expenseDao)
        allexpense = repository.allExpens
    }


    fun insert(expens: Expenses) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(expens)
    }
}