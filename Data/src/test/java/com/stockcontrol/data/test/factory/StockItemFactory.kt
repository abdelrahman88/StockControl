package com.stockcontrol.data.test.factory

import com.stockcontrol.data.model.SalesEntity
import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.model.StockQuantitiesEntity
import com.stockcontrol.domain.model.Sales
import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.domain.model.StockQuantities

object StockItemFactory {

    fun makeStockQuantitiesEntity() : StockQuantitiesEntity {
        return StockQuantitiesEntity(DataFactory.randomUuid() , DataFactory.randomFloat() , DataFactory.randomFloat())
    }

    fun makeStockQuantitiesEntityList(count : Int) : List<StockQuantitiesEntity>{
        val stockQuantitiesList = mutableListOf<StockQuantitiesEntity>()
        repeat(count){
            stockQuantitiesList.add(makeStockQuantitiesEntity())
        }
        return stockQuantitiesList
    }

    fun makeSalesEntity() : SalesEntity {
        return SalesEntity(
            DataFactory.randomInt() , DataFactory.randomUuid() , DataFactory.randomUuid() , DataFactory.randomFloat() , DataFactory.randomFloat() ,
            DataFactory.randomUuid()
        )
    }

    fun makeSalesEntityList(count : Int) : List<SalesEntity>{
        val salesList = mutableListOf<SalesEntity>()
        repeat(count){
            salesList.add(makeSalesEntity())
        }
        return salesList
    }

    fun makeStockItemEntity() : StockITemEntity{
        return StockITemEntity(
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomFloat(), makeStockQuantitiesEntityList(3) , makeSalesEntityList(3))
    }


    fun makeStockQuantities() : StockQuantities {
        return StockQuantities(DataFactory.randomUuid() , DataFactory.randomFloat() , DataFactory.randomFloat())
    }

    fun makeStockQuantitiesList(count : Int) : List<StockQuantities>{
        val stockQuantitiesList = mutableListOf<StockQuantities>()
        repeat(count){
            stockQuantitiesList.add(makeStockQuantities())
        }
        return stockQuantitiesList
    }

    fun makeSales() : Sales {
        return Sales(
            DataFactory.randomInt() , DataFactory.randomUuid() , DataFactory.randomUuid() , DataFactory.randomFloat() , DataFactory.randomFloat() ,
            DataFactory.randomUuid()
        )
    }

    fun makeSalesList(count : Int) : List<Sales>{
        val salesList = mutableListOf<Sales>()
        repeat(count){
            salesList.add(makeSales())
        }
        return salesList
    }

    fun makeStockItem() : StockItem{
        return StockItem(
            DataFactory.randomUuid(),
            DataFactory.randomUuid(),
            DataFactory.randomFloat(), makeStockQuantitiesList(3) , makeSalesList(3))
    }

}
