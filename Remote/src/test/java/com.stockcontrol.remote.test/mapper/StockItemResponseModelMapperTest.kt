package com.stockcontrol.remote.test.mapper

import com.stockcontrol.remote.mapper.SalesResponseModelMapper
import com.stockcontrol.remote.mapper.StockITemResponseModelMapper
import com.stockcontrol.remote.mapper.StockQuantitiesResponseModelMapper
import com.stockcontrol.remote.test.factory.StockItemDataFactory
import org.junit.Test
import kotlin.test.assertEquals

class StockItemResponseModelMapperTest {

    private val salesMapper  =SalesResponseModelMapper()
    private val stockMapper  =StockQuantitiesResponseModelMapper()
    private val mapper = StockITemResponseModelMapper(salesMapper, stockMapper)

    @Test
    fun mapFromModelMapsData(){
        val model = StockItemDataFactory.makeStockItem()
        val entity = mapper.mapFromModel(model)

        assertEquals(model.id , entity.id)
        assertEquals(model.name , entity.name)
        assertEquals(model.price , entity.price)
        assertEquals(model.sales.map {
            it.invoiceNo
        } , entity.sales.map {
            it.invoiceNo
        })
        assertEquals(model.sales.map {
            it.invoiceDate
        } , entity.sales.map {
            it.invoiceDate
        })
        assertEquals(model.sales.map {
            it.invoiceQty
        } , entity.sales.map {
            it.invoiceQty
        })
        assertEquals(model.sales.map {
            it.reservedQty
        } , entity.sales.map {
            it.reservedQty
        })
        assertEquals(model.sales.map {
            it.salesMan
        } , entity.sales.map {
            it.salesMan
        })
        assertEquals(model.stock.map {
            it.availableQty
        } , entity.stock.map {
            it.availableQty
        })

        assertEquals(model.stock.map {
            it.reservedQty
        } , entity.stock.map {
            it.reservedQty
        })
    }

}