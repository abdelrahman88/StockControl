package com.stockcontrol.data.model

data class StockITemEntity(
    val id: String, val name: String, val price: Float
    , val stock: List<StockQuantitiesEntity>, val sales: List<SalesEntity>)


data class StockQuantitiesEntity(val stockName: String, val availableQty: Float, val reservedQty: Float)

data class SalesEntity(
    val invoiceNo: Int, val invoiceDate: String, val customer: String
    , val invoiceQty: Float, val reservedQty: Float, val salesMan: String
)

