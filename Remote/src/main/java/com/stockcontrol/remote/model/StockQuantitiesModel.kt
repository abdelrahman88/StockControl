package com.stockcontrol.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class  StockQuantitiesModel (@Json(name = "Warehouse")val stockName : String,
                            @Json(name = "FreeQTY")val availableQty : Float,
                            @Json(name = "ReservedQTY")val reservedQty : Float) {
}