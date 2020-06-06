package com.abhishek.googledemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExpensesDao {

    @Query("SELECT * from Expenses")
    fun getAlphabetizedWords(): LiveData<List<Expenses>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expens: Expenses)


}