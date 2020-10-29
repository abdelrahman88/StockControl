package com.stockcontrol.domain.model

data class StockItem(
    val id: String, val name: String, val price: Float
    , val stock: List<StockQuantities>, val sales: List<Sales>)

data class StockQuantities(val stockName: String, val availableQty: Float, val reservedQty: Float)

data class Sales(
    val invoiceNo: Int, val invoiceDate: String, val customer: String
    , val invoiceQty: Float, val reservedQty: Float, val salesMan: String)


