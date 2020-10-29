package com.stockcontrol.mobile_ui.base.mapper

import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.mobile_ui.base.model.StockItemView
import javax.inject.Inject

class StockItemViewMapper @Inject constructor(
    private val salesViewMapper: SalesViewMapper ,
    private val stockQuantitiesViewMapper: StockQuantitiesViewMapper
) : ViewMapper<StockItemView , StockItem> {
    override fun mapToView(domain: StockItem): StockItemView {
        return StockItemView(domain.id , domain.name , domain.price
            ,domain.stock.map {
            stockQuantitiesViewMapper.mapToView(it)
        }  ,domain.sales.map {
            salesViewMapper.mapToView(it)
        }
        )
    }
}