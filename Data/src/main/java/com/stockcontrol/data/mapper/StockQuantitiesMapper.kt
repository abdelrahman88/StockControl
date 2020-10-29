package com.stockcontrol.data.mapper

import com.stockcontrol.data.model.StockQuantitiesEntity
import com.stockcontrol.domain.model.StockQuantities
import javax.inject.Inject

class StockQuantitiesMapper @Inject constructor() : EntityMapper<StockQuantitiesEntity , StockQuantities>{
    override fun mapToEntity(domain: StockQuantities): StockQuantitiesEntity {
        return StockQuantitiesEntity(domain.stockName , domain.availableQty , domain.reservedQty)
    }

    override fun mapFromEntity(entity: StockQuantitiesEntity): StockQuantities {
        return StockQuantities(entity.stockName , entity.availableQty , entity.reservedQty)
    }
}