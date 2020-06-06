package com.abhishek.googledemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Expenses::class), version = 1, exportSchema = false)
abstract    class ExpensDataBase : RoomDatabase() {

    abstract fun expensDao(): ExpensesDao
    companion object{
        @Volatile
        private var INSTANCE: ExpensDataBase? = null

        fun getDatabase(context: Context): ExpensDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpensDataBase::class.java,
                    "expens_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}