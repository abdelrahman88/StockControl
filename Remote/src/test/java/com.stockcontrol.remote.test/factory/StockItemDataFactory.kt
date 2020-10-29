package com.stockcontrol.remote.test.factory

import com.stockcontrol.data.model.SalesEntity
import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.data.model.StockQuantitiesEntity
import com.stockcontrol.remote.model.SalesModel
import com.stockcontrol.remote.model.StockItemModel
import com.stockcontrol.remote.model.StockItemResponseModel
import com.stockcontrol.remote.model.StockQuantitiesModel

object StockItemDataFactory {

    fun makeSales() : SalesModel{
        return SalesModel(DataFactory.randomInt() , DataFactory.randomUuid() , DataFactory.randomUuid()
        ,DataFactory.randomFloat() , DataFactory.randomFloat() , DataFactory.randomUuid())
    }
    fun makeStockItem() : StockItemModel{
        return StockItemModel(DataFactory.randomUuid() , DataFactory.randomUuid() , DataFactory.randomFloat()
            , makeStockQuantitiesList(3) ,makeSalesList(3)  )

    }
    fun makeStockQuantities() : StockQuantitiesModel{
        return StockQuantitiesModel(DataFactory.randomUuid() , DataFactory.randomFloat() , DataFactory.randomFloat())
    }
    fun makeStockItemEntity() : StockITemEntity {
        return StockITemEntity(DataFactory.randomUuid() , DataFactory.randomUuid() , DataFactory.randomFloat()
        , makeStockQuantitiesEntityList(3) , makeSalesEntityList(3))
    }
    fun makeStockQuantitiesEntity() : StockQuantitiesEntity {
        return StockQuantitiesEntity(DataFactory.randomUuid() , DataFactory.randomFloat() ,DataFactory.randomFloat())
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

    fun makeStockQuantitiesList(count : Int) : List<StockQuantitiesModel>{
        val stockQuantitiesList = mutableListOf<StockQuantitiesModel>()
        repeat(count){
            stockQuantitiesList.add(makeStockQuantities())
        }
        return stockQuantitiesList
    }

    fun makeSalesList(count : Int) : List<SalesModel>{
        val salesList = mutableListOf<SalesModel>()
        repeat(count){
            salesList.add(makeSales())
        }
        return salesList
    }


    fun makeStockItemResponse() : StockItemResponseModel{
        return StockItemResponseModel(makeStockItem())
    }
}