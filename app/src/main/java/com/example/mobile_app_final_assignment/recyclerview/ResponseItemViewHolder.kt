package com.example.mobile_app_final_assignment.recyclerview

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.models.ResponseItem

class ResponseItemViewHolder(view: View,private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val property1: TextView = view.findViewById(R.id.property1Text)
    private val property2: TextView = view.findViewById(R.id.property2Text)
    private val description: TextView = view.findViewById(R.id.descriptionText)
    private val viewDetailsButton: Button = view.findViewById(R.id.navigationButton)

    fun bind(item: ResponseItem) {
        property1.text = item.property1
        property2.text = item.property2
        description.text = item.description

        viewDetailsButton.setOnClickListener {
                navigationFunction(item)
            }
        }
    }

