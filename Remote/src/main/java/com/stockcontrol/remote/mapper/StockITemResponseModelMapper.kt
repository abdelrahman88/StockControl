package com.stockcontrol.remote.mapper

import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.remote.model.StockItemModel
import javax.inject.Inject

class StockITemResponseModelMapper @Inject constructor(
    private val salesMapper : SalesResponseModelMapper,
    private val stockMapper : StockQuantitiesResponseModelMapper
) :ModelMapper<StockItemModel , StockITemEntity>{

    override fun mapFromModel(model: StockItemModel): StockITemEntity {
        return StockITemEntity(model.id, model.name , model.price
            ,model.stock.map {
            stockMapper.mapFromModel(it)
        } , model.sales.map {
            salesMapper.mapFromModel(it)
        }
        )
    }
}