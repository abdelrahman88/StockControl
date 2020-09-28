package com.stockcontrol.domain.model

data class StockItem( val id : String , val name : String , val price : String
                      , val stock: List<Stock> , val sales : List<Sales>) {
}


data class Sales(val invoiceNo : String , val invoiceDate : String , val client : String
                 , val invoiceQty : String , val reservedQty : String) {
}


data class Stock( val id : String , val availableQty : String , val reservedQty : String) {
}