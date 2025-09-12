package com.example.mobile_app_final_assignment.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.models.DashboardItem

class ResponseItemViewHolder(
    view: View,
    private val navigationFunction: (DashboardItem) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val nameText: TextView = view.findViewById(R.id.nameText)
    private val architectName: TextView = view.findViewById(R.id.architectName)
    private val yearCompleted: TextView = view.findViewById(R.id.yearCompletedText)
    private val viewDetailsButton: Button = view.findViewById(R.id.navigationButton)

    fun bind(item: DashboardItem) {
        nameText.text = item.name
        architectName.text = item.architect
        yearCompleted.text = item.yearCompleted

        viewDetailsButton.setOnClickListener {
            navigationFunction(item)
        }
    }
}
