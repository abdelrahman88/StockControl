package com.stockcontrol.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class StockItemModel(@Json(name = "PartNo")val id : String,
                     @Json(name = "PartName")val name : String,
                     @Json(name = "PartPrice")val price : Float,
                     @Json(name = "PartWarehouses")val stock: List<StockQuantitiesModel>,
                     @Json(name = "PartReservedInvoices")val sales : List<SalesModel>)