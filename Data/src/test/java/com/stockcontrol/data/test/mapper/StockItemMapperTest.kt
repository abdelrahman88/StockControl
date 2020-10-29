package com.stockcontrol.data.test.mapper

import com.stockcontrol.data.mapper.SalesMapper
import com.stockcontrol.data.mapper.StockItemMapper
import com.stockcontrol.data.mapper.StockQuantitiesMapper
import com.stockcontrol.data.model.SalesEntity
import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.test.factory.StockItemFactory
import com.stockcontrol.domain.model.Sales
import com.stockcontrol.domain.model.StockItem
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class StockItemMapperTest {
    private val salesMapper = SalesMapper()
    private val stockMapper = StockQuantitiesMapper()
    val mapper = StockItemMapper(salesMapper , stockMapper)

    @Test
    fun mapFromEntityMapsData(){
        val entity = StockItemFactory.makeStockItemEntity()
        val model = mapper.mapFromEntity(entity)
        assertEqualData(entity , model)
    }

    @Test
    fun mapToEntityMapsData(){
        val model = StockItemFactory.makeStockItem()
        val entity = mapper.mapToEntity(model)
        assertEqualData(entity , model)
    }

    fun assertEqualData(entity: StockITemEntity , model : StockItem){
        assertEquals(entity.id , model.id)
        assertEquals(entity.name , model.name)
        assertEquals(entity.price , model.price)
//        val salesEntity = StockItemFactory.makeSalesEntity()
//        val salesModel = salesMapper.mapFromEntity(salesEntity)
//        assertEqualSalesData(salesEntity , salesModel)

        assertEquals(entity.sales.map {
            it.invoiceNo
        } , model.sales.map {
            it.invoiceNo
        })

        assertEquals(entity.sales.map {
            it.invoiceDate
        } , model.sales.map {
            it.invoiceDate
        })

        assertEquals(entity.sales.map {
            it.invoiceQty
        } , model.sales.map {
            it.invoiceQty
        })

        assertEquals(entity.sales.map {
            it.reservedQty
        } , model.sales.map {
            it.reservedQty
        })

        assertEquals(entity.sales.map {
            it.customer
        } , model.sales.map {
            it.customer
        })

        assertEquals(entity.sales.map {
            it.salesMan
        } , model.sales.map {
            it.salesMan
        })

        assertEquals(entity.stock.map {
            it.stockName
        } , model.stock.map {
            it.stockName
        })

        assertEquals(entity.stock.map {
            it.availableQty
        } , model.stock.map {
            it.availableQty
        })

        assertEquals(entity.stock.map {
            it.reservedQty
        } , model.stock.map {
            it.reservedQty
        })
    }


//    fun assertEqualSalesData(salesEntity: SalesEntity , sales: Sales){
//
//        assertEquals(salesEntity.invoiceNo , sales.invoiceNo)
//        assertEquals(entity.name , model.name)
//        assertEquals(entity.price , model.price)
//    }
}