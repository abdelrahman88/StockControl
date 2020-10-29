package com.stockcontrol.data.test

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.stockcontrol.data.StockItemDataRepository
import com.stockcontrol.data.mapper.StockItemMapper
import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.repository.StockItemDataStore
import com.stockcontrol.data.store.StockItemDataStoreFactory
import com.stockcontrol.data.test.factory.DataFactory
import com.stockcontrol.data.test.factory.StockItemFactory
import com.stockcontrol.domain.model.StockItem
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StockItemDataRepositoryTest {

    private val mapper =  mock<StockItemMapper>()
    private val factory = mock<StockItemDataStoreFactory>()
    private val store = mock<StockItemDataStore>()
    private val repository = StockItemDataRepository(mapper , factory)

    @Before
    fun setup(){
        stubFactoryGetDataStore()
    }

    @Test
    fun getStockItemCompletes(){
        stubGetStockItem(Single.just(StockItemFactory.makeStockItemEntity()))
        stubMapper(StockItemFactory.makeStockItem() , any())
        val testObserver = repository.getStockItemDetails(DataFactory.randomUuid()).test()
        testObserver.assertComplete()
    }

    @Test
    fun getStockItemReturnsData(){
        val stockITemEntity = StockItemFactory.makeStockItemEntity()
        val stockItem = StockItemFactory.makeStockItem()
        stubGetStockItem(Single.just(stockITemEntity))
        stubMapper(stockItem,stockITemEntity)
        val testObserver = repository.getStockItemDetails(DataFactory.randomUuid()).test()
        testObserver.assertValue(stockItem)
    }

    private fun stubMapper(model : StockItem , entity : StockITemEntity){
        whenever(mapper.mapFromEntity(entity))
            .thenReturn(model)
    }
    private fun stubFactoryGetDataStore(){
        whenever(factory.getDataStore())
            .thenReturn(store)
    }
    private fun stubGetStockItem(observable : Single<StockITemEntity>){
        whenever(store.getStockItemDetails(any()))
            .thenReturn(observable)
    }
}

