package com.stockcontrol.domain.model

data class StockItem( val id : String , val name : String , val price : String
                      , val stock: List<Stock> , val sales : List<Sales>) {
}