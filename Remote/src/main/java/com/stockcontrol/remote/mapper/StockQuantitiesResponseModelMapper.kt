package com.stockcontrol.remote.mapper

import com.stockcontrol.data.model.StockQuantitiesEntity
import com.stockcontrol.remote.model.StockQuantitiesModel
import javax.inject.Inject

class StockQuantitiesResponseModelMapper @Inject constructor()
    : ModelMapper<StockQuantitiesModel , StockQuantitiesEntity > {
    override fun mapFromModel(model: StockQuantitiesModel): StockQuantitiesEntity {
        return StockQuantitiesEntity(model.stockName , model.availableQty , model.reservedQty)
    }
}