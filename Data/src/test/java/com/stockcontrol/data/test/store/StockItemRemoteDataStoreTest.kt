package com.stockcontrol.data.test.store

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.repository.StockItemRemote
import com.stockcontrol.data.store.StockItemRemoteDataStore
import com.stockcontrol.data.test.factory.DataFactory
import com.stockcontrol.data.test.factory.StockItemFactory
import io.reactivex.Single
import org.junit.Test

class StockItemRemoteDataStoreTest {

    private val remote = mock<StockItemRemote>()
    private val store = StockItemRemoteDataStore(remote)

    @Test
    fun getStockItemCompletes(){
        stubRemoteGetStockItem(Single.just(StockItemFactory.makeStockItemEntity()))
        val observerTest = store.getStockItemDetails(DataFactory.randomUuid()).test()
        observerTest.assertComplete()

    }

    @Test
    fun getStockItemReturnsData(){
        val data = StockItemFactory.makeStockItemEntity()
        stubRemoteGetStockItem(Single.just(data))
        val observerTest = store.getStockItemDetails(DataFactory.randomUuid()).test()
        observerTest.assertValue(data)

    }
    private fun stubRemoteGetStockItem(observable: Single<StockITemEntity>){
        whenever(remote.getStockItemDetails(any()))
            .thenReturn(observable)
    }
}