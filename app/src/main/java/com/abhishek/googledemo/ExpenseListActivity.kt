package com.abhishek.googledemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExpenseListActivity : AppCompatActivity() {
    private lateinit var mExpenseViewModal: ExpenseViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ExpenseAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

//        mExpenseViewModal = ViewModelProvider(this).get(ExpenseViewModal::class.java)
//
//        mExpenseViewModal.allexpense.observe(this, Observer {
//            it.let {
//                adapter.setWords(it)
//            }
//
//        })

        val expenseDao = ExpensDataBase.getDatabase(application).expensDao()
        val repository = ExpenseDataRepository(expenseDao)
        val allexpense = repository.allExpens

        allexpense.observe(this, Observer {
            it.let {
                adapter.setWords(it)
            }
        })


        val floatingButton = findViewById<FloatingActionButton>(R.id.fab)
        floatingButton.setOnClickListener {
            val intent = Intent(this@ExpenseListActivity,MainActivity::class.java)
            startActivityForResult(intent,111)
        }
    }
}