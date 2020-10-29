package com.stockcontrol.mobile_ui.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stockcontrol.mobile_ui.R
import com.stockcontrol.mobile_ui.base.model.StockQuantitiesView


class StockQuantitiesAdapter() :
    RecyclerView.Adapter<StockQuantitiesAdapter.StockQuantitiesViewHolder>() {
     private var adapterList: ArrayList<StockQuantitiesView> = ArrayList()

    fun setAdapterList(adapterList: ArrayList<StockQuantitiesView>) {
        this.adapterList = adapterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockQuantitiesViewHolder {
        return StockQuantitiesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.stock_qtys_view_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onBindViewHolder(holder: StockQuantitiesViewHolder, position: Int) {
            holder.bind(adapterList[position])
    }

    class StockQuantitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val available_qty : TextView = itemView.findViewById(R.id.available_qty)
        val reserved_qty : TextView = itemView.findViewById(R.id.reserved_qty)
        val stock_name : TextView = itemView.findViewById(R.id.stock_name)

        fun bind(stockQuantitiesView: StockQuantitiesView){
            available_qty.text = stockQuantitiesView.availableQty.toString()
            reserved_qty.text = stockQuantitiesView.reservedQty.toString()
            stock_name.text = stockQuantitiesView.stockName
        }
    }
}