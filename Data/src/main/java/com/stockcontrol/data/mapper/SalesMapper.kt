package com.stockcontrol.data.mapper

import com.stockcontrol.data.model.SalesEntity
import com.stockcontrol.domain.model.Sales
import javax.inject.Inject

class SalesMapper @Inject constructor() : EntityMapper<SalesEntity , Sales> {
    override fun mapToEntity(domain: Sales): SalesEntity {
        return SalesEntity(domain.invoiceNo , domain.invoiceDate , domain.customer ,
            domain.invoiceQty , domain.reservedQty , domain.salesMan)
    }

    override fun mapFromEntity(entity: SalesEntity): Sales {
        return Sales(entity.invoiceNo , entity.invoiceDate , entity.customer ,
            entity.invoiceQty , entity.reservedQty , entity.salesMan)
    }
}