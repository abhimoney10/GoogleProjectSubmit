package com.abhishek.googledemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Expenses")
data class Expenses(
    @PrimaryKey @ColumnInfo(name = "time") val time: Long,
               @ColumnInfo(name = "amount") val amount: String,
               @ColumnInfo(name = "purchaseItem") val purchaseItem: String,
               @ColumnInfo(name = "date") val date: String,
               @ColumnInfo(name = "desc") val desc: String){

}