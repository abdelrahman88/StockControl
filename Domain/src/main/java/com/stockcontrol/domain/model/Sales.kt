package com.stockcontrol.domain.model

data class Sales(val invoiceNo : String , val invoiceDate : String , val client : String
                 , val invoiceQty : String , val reservedQty : String) {
}