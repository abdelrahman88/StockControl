package com.stockcontrol.mobile_ui.di

import com.stockcontrol.data.StockItemDataRepository
import com.stockcontrol.domain.repository.StockItemRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindStockItemRepository(stockItemDataRepository: StockItemDataRepository):StockItemRepository
}