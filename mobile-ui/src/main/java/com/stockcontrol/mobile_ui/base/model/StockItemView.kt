package com.stockcontrol.mobile_ui.base.model

class StockItemView(
    val id: String, val name: String, val price: Float
    , val stock: List<StockQuantitiesView>, val sales: List<SalesView>)

data class StockQuantitiesView(val stockName: String, val availableQty: Float, val reservedQty: Float)

data class SalesView(
    val invoiceNo: Int, val invoiceDate: String, val customer: String
    , val invoiceQty: Float, val reservedQty: Float , val salesMan : String)