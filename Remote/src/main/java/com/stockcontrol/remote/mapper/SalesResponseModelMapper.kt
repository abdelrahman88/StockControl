package com.stockcontrol.remote.mapper

import com.stockcontrol.data.model.SalesEntity
import com.stockcontrol.remote.model.SalesModel
import javax.inject.Inject

class SalesResponseModelMapper @Inject constructor() : ModelMapper<SalesModel , SalesEntity> {
    override fun mapFromModel(model: SalesModel): SalesEntity {
        return SalesEntity(model.invoiceNo , model.invoiceDate , model.customer
            , model.invoiceQty , model.reservedQty , model.salesMan)
    }
}