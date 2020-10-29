package com.stockcontrol.data

import com.stockcontrol.data.mapper.StockItemMapper
import com.stockcontrol.data.store.StockItemDataStoreFactory
import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.domain.repository.StockItemRepository
import io.reactivex.Single
import javax.inject.Inject

class StockItemDataRepository @Inject constructor(
    val mapper: StockItemMapper ,
    val factory : StockItemDataStoreFactory
) : StockItemRepository {

    override fun getStockItemDetails(id :String): Single<StockItem> {

        return   factory.getDataStore().getStockItemDetails(id)
               .map {
                   mapper.mapFromEntity(it)
               }
    }
}