package com.abhishek.googledemo

import androidx.lifecycle.LiveData

class ExpenseDataRepository (private val mExpensesDao: ExpensesDao) {

     val allExpens: LiveData<List<Expenses>> = mExpensesDao.getAlphabetizedWords()

    suspend fun insert(mExpense: Expenses) {
        mExpensesDao.insert(mExpense)
    }
}