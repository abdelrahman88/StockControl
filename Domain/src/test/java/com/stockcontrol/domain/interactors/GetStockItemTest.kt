package com.stockcontrol.domain.interactors

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import com.stockcontrol.domain.executor.PostExecutionThread
import com.stockcontrol.domain.interactors.browse.GetStockItem
import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.domain.repository.StockItemRepository
import com.stockcontrol.domain.test.StockItemDataFactory
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetStockItemTest {

    private lateinit var getStockItem: GetStockItem
    @Mock lateinit var stockItemRepository: StockItemRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        getStockItem = GetStockItem(stockItemRepository , postExecutionThread)
    }

    @Test
    fun getStockItemCompletes(){
        stubGetStockItem(Single.just(StockItemDataFactory.makeStockItem()))
        val testObserver =  getStockItem.buildSingleUseCase(
            GetStockItem.Params.forStockItem(StockItemDataFactory.randomUuid())
        ).test()
        testObserver.assertComplete()
    }

    @Test
    fun getStockItemReturnsData(){
        val stockItem = StockItemDataFactory.makeStockItem()
        stubGetStockItem(Single.just(stockItem))
        val testObserver =  getStockItem.buildSingleUseCase(
            GetStockItem.Params.forStockItem(StockItemDataFactory.randomUuid())
        ).test()
        testObserver.assertValue(stockItem)
    }

    @Test(expected = IllegalArgumentException::class)
    fun stockItemThrowsException(){
        getStockItem.buildSingleUseCase().test()
    }

    private fun stubGetStockItem(observable : Single<StockItem>){
        whenever(stockItemRepository.getStockItemDetails(any()))
            .thenReturn(observable)
    }
}