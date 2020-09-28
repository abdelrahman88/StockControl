package com.stockcontrol.domain.repository

import com.stockcontrol.domain.model.StockItem
import io.reactivex.Single

interface StockItemRepository {
    fun getStockItemDetails(itemId : String) : Single<StockItem>
}