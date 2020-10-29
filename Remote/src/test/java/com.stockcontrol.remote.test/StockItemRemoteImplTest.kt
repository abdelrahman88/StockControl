package com.stockcontrol.remote.test

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.remote.StockItemRemoteImpl
import com.stockcontrol.remote.mapper.StockITemResponseModelMapper
import com.stockcontrol.remote.model.StockItemModel
import com.stockcontrol.remote.model.StockItemResponseModel
import com.stockcontrol.remote.service.StockControlService
import com.stockcontrol.remote.test.factory.DataFactory
import com.stockcontrol.remote.test.factory.StockItemDataFactory
import io.reactivex.Single
import org.junit.Test
import retrofit2.http.Query

class StockItemRemoteImplTest {

    private val mapper = mock<StockITemResponseModelMapper>()
    private val service = mock<StockControlService>()
    private val remote = StockItemRemoteImpl(mapper , service)

    @Test
    fun getStockItemCompletes(){
        stubStockControlServiceGetStockItemDetails(Single.just(StockItemDataFactory.makeStockItemResponse()))
        stubStockItemResponseModelMapperMapForModel(any() , StockItemDataFactory.makeStockItemEntity())
        val testObserver = remote.getStockItemDetails(DataFactory.randomUuid()).test()
        testObserver.assertComplete()
    }

    @Test
    fun getStockItemCallsServer(){
        stubStockControlServiceGetStockItemDetails(Single.just(StockItemDataFactory.makeStockItemResponse()))
        stubStockItemResponseModelMapperMapForModel(any() , StockItemDataFactory.makeStockItemEntity())
         remote.getStockItemDetails(DataFactory.randomUuid()).test()
        verify(service).getStockItemDetails(any())
    }

    @Test
    fun getStockItemReturnsData(){
        val response = StockItemDataFactory.makeStockItemResponse()
        stubStockControlServiceGetStockItemDetails(Single.just(response))
        val entity = StockItemDataFactory.makeStockItemEntity()
        stubStockItemResponseModelMapperMapForModel(response.stockItem , entity)
        val testObserver = remote.getStockItemDetails(DataFactory.randomUuid()).test()
        testObserver.assertValue(entity)
    }

    private fun stubStockControlServiceGetStockItemDetails(observable : Single<StockItemResponseModel>){
        whenever(service.getStockItemDetails(any()))
            .thenReturn(observable)

    }
    private fun stubStockItemResponseModelMapperMapForModel(model : StockItemModel , entity: StockITemEntity){
        whenever(mapper.mapFromModel(model))
            .thenReturn(entity)
    }
}