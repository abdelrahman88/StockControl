package com.stockcontrol.data.repository

import com.stockcontrol.data.model.StockITemEntity
import io.reactivex.Single

interface StockItemDataStore {

    fun getStockItemDetails(id : String) : Single<StockITemEntity>
}