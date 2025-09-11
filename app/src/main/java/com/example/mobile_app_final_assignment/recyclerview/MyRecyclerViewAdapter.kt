package com.example.mobile_app_final_assignment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.models.ResponseItem

class MyRecyclerViewAdapter(private val dataList: MutableList<ResponseItem> = mutableListOf(), private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.Adapter<ResponseItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseItemViewHolder {
        val view = LayoutInflater.from(parent.context) .inflate(R.layout.item_layout_api, parent, false)
        return ResponseItemViewHolder(view, navigationFunction = navigationFunction)
    }

    override fun onBindViewHolder(viewHolder: ResponseItemViewHolder, position: Int) {
        viewHolder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setData(newDataList: List<ResponseItem>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}