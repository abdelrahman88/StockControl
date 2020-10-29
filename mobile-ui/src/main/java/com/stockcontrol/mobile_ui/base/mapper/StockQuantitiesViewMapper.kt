package com.stockcontrol.mobile_ui.base.mapper

import com.stockcontrol.domain.model.StockQuantities
import com.stockcontrol.mobile_ui.base.model.StockQuantitiesView
import javax.inject.Inject

class StockQuantitiesViewMapper @Inject constructor() : ViewMapper<StockQuantitiesView , StockQuantities> {
    override fun mapToView(domain: StockQuantities): StockQuantitiesView {
        return StockQuantitiesView(domain.stockName , domain.availableQty , domain.reservedQty)
    }
}