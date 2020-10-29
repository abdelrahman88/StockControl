package com.stockcontrol.data.store

import com.stockcontrol.data.repository.StockItemDataStore
import javax.inject.Inject

open class StockItemDataStoreFactory @Inject constructor(private val stockItemRemoteDataStore: StockItemRemoteDataStore) {

    open fun getDataStore() : StockItemDataStore{
        return stockItemRemoteDataStore
    }

}