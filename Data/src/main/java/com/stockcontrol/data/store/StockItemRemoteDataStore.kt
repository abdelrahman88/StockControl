package com.stockcontrol.data.store

import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.repository.StockItemDataStore
import com.stockcontrol.data.repository.StockItemRemote
import io.reactivex.Single
import javax.inject.Inject

class StockItemRemoteDataStore @Inject constructor(private val stockItemRemote: StockItemRemote):StockItemDataStore {

    override fun getStockItemDetails(id : String): Single<StockITemEntity> {
      return  stockItemRemote.getStockItemDetails(id)
    }
}