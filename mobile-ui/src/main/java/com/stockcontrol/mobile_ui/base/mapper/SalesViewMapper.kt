package com.stockcontrol.mobile_ui.base.mapper

import com.stockcontrol.domain.model.Sales
import com.stockcontrol.mobile_ui.base.model.SalesView
import javax.inject.Inject

class SalesViewMapper @Inject constructor() : ViewMapper<SalesView ,Sales> {
    override fun mapToView(domain: Sales): SalesView {
        return SalesView(domain.invoiceNo , domain.invoiceDate , domain.customer ,
            domain.invoiceQty , domain.reservedQty , domain.salesMan)
    }
}