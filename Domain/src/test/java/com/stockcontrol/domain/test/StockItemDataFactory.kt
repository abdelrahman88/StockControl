package com.stockcontrol.domain.test

import com.stockcontrol.domain.model.Sales
import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.domain.model.StockQuantities
import java.util.*

object StockItemDataFactory {

    fun randomUuid() : String{
        return UUID.randomUUID().toString()
    }
     fun randomFloat() : Float{
         val random = Random()
         return random.nextFloat()
     }

    fun randomInt () : Int{
        val random =  Random()
        return  random.nextInt()
    }

    fun makeStockQuantities() : StockQuantities{
        return StockQuantities(randomUuid() , randomFloat() , randomFloat())
    }

    fun makeStockQuantitiesList(count : Int) : List<StockQuantities>{
        val stockQuantitiesList = mutableListOf<StockQuantities>()
        repeat(count){
            stockQuantitiesList.add(makeStockQuantities())
        }
        return stockQuantitiesList
    }

    fun makeSales() : Sales{
        return Sales(randomInt() , randomUuid() , randomUuid() , randomFloat() , randomFloat() ,
            randomUuid())
    }

    fun makeSalesList(count : Int) : List<Sales>{
        val salesList = mutableListOf<Sales>()
        repeat(count){
            salesList.add(makeSales())
        }
        return salesList
    }

    fun makeStockItem() : StockItem{
        return StockItem(randomUuid() , randomUuid() , randomFloat() , makeStockQuantitiesList(3) , makeSalesList(3))
    }
}