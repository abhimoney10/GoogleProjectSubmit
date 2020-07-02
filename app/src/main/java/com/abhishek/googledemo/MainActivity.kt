package com.abhishek.googledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var et_amount : EditText
    lateinit var et_purchase_item : EditText
    lateinit var et_purchase_date : EditText
    lateinit var et_description : EditText

    private lateinit var mExpenseViewModal: ExpenseViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         et_amount = findViewById(R.id.et_amount)
         et_purchase_item = findViewById(R.id.et_purchase_item)
         et_purchase_date = findViewById(R.id.et_purchase_date)
         et_description = findViewById(R.id.et_description)
        val btn_save = findViewById<Button>(R.id.btn_save)

        mExpenseViewModal = ViewModelProvider(this).get(ExpenseViewModal::class.java)

        btn_save.setOnClickListener {
            val expens = saveData()
            expens?.let {
                    it1 -> mExpenseViewModal.insert(it1)
                finish()
            }
        }
    }

    fun saveData(): Expenses? {
        val purchaseItem = et_purchase_item.text.toString()
        val amount = et_amount.text.toString()
        val date = et_purchase_date.text.toString()
        val desc = et_description.text.toString()
        if(purchaseItem.isNullOrEmpty()){
            showToastMsg("Please Enter Purchase Item")
        }else  if(amount.isNullOrEmpty()){
            showToastMsg("Please Enter amount")
        } else  if(date.isNullOrEmpty()){
            showToastMsg("Please Enter date")
        }else {
            val datetime = Date()
            val expens = Expenses(datetime.time,amount,purchaseItem,date,desc)
           return expens
        }

        return null
    }
    fun showToastMsg(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}