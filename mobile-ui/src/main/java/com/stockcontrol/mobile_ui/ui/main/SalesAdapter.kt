package com.stockcontrol.mobile_ui.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stockcontrol.mobile_ui.R
import com.stockcontrol.mobile_ui.base.model.SalesView

class SalesAdapter() : RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {
    private  var adapterList: ArrayList<SalesView>  = ArrayList()

    fun setAdapterList(adapterList: ArrayList<SalesView>) {
        this.adapterList = adapterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        return SalesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.sales_view_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.bind(adapterList[position])
    }

    class SalesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val invoice_no : TextView = itemView.findViewById(R.id.invoice_no)
        val invoice_date : TextView = itemView.findViewById(R.id.invoice_date)
        val customer : TextView = itemView.findViewById(R.id.customer)
        val invoice_qty : TextView = itemView.findViewById(R.id.invoice_qty)
        val reserved_qty : TextView = itemView.findViewById(R.id.reserved_qty)
        val sales_man : TextView = itemView.findViewById(R.id.sales_man)

        fun bind(salesView: SalesView){
            invoice_no.text = salesView.invoiceNo.toString()
            invoice_date.text = salesView.invoiceDate
            customer.text = salesView.customer
            invoice_qty.text = salesView.invoiceQty.toString()
            reserved_qty.text = salesView.reservedQty.toString()
            sales_man.text = salesView.salesMan

            }
    }
}