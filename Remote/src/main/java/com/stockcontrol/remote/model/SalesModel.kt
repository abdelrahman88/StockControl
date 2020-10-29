package com.stockcontrol.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SalesModel(@Json(name = "InvoiceNo")val invoiceNo : Int,
                 @Json(name = "InvoiceDate")val invoiceDate : String,
                 @Json(name = "Customer")val customer : String,
                 @Json(name = "InvoiceQTY")val invoiceQty : Float,
                 @Json(name = "ReservedQTY")val reservedQty : Float,
                 @Json(name = "SalesMan")val salesMan : String)