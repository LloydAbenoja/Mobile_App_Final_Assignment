package com.example.mobile_app_final_assignment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_final_assignment.R
import com.example.mobile_app_final_assignment.models.DashboardItem

class MyRecyclerViewAdapter(
    private val dataList: MutableList<DashboardItem> = mutableListOf(),
    private val navigationFunction: (DashboardItem) -> Unit
) : RecyclerView.Adapter<ResponseItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_api, parent, false)
        return ResponseItemViewHolder(view, navigationFunction)
    }

    override fun onBindViewHolder(holder: ResponseItemViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setData(newDataList: List<DashboardItem>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }
}
