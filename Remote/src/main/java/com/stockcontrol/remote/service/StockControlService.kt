package com.stockcontrol.remote.service

import com.stockcontrol.remote.model.StockItemModel
//import com.stockcontrol.remote.model.StockItemResponseModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StockControlService {

    @GET("PartEnquiry")
    fun getStockItemDetails(@Query("partNo") partNo : String) : Single<StockItemModel>

}