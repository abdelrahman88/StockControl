package com.stockcontrol.remote

import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.repository.StockItemRemote
import com.stockcontrol.remote.mapper.StockITemResponseModelMapper
import com.stockcontrol.remote.service.StockControlService
import io.reactivex.Single
import javax.inject.Inject

class StockItemRemoteImpl @Inject constructor(
    private val mapper: StockITemResponseModelMapper,
    private val service: StockControlService
) : StockItemRemote {
    override fun getStockItemDetails(id: String): Single<StockITemEntity> {
        val itemDetails = service.getStockItemDetails(id)
        return itemDetails.map {
            mapper.mapFromModel(it)
        }
    }
}