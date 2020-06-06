package com.abhishek.googledemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpenseAdapter  internal constructor(
    context: Context
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var expenses = emptyList<Expenses>() // Cached copy of words

    inner class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expensItem: TextView = itemView.findViewById(R.id.tv_item)
        val expensAmount: TextView = itemView.findViewById(R.id.tv_amount)
        val expensDate: TextView = itemView.findViewById(R.id.tv_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val itemView = inflater.inflate(R.layout.list_item, parent, false)
        return ExpenseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val current = expenses[position]
        holder.expensItem.let {
            it.setText(current.purchaseItem)
        }

        holder.expensAmount.let {
            it.setText(current.amount)
        }

        holder.expensDate.let {
            it.setText(current.date)
        }

    }

    internal fun setWords(expensList: List<Expenses>) {
        this.expenses = expensList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return expenses.size
    }
}
