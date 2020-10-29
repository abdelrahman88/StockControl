package com.stockcontrol.data.mapper

import com.stockcontrol.data.model.StockITemEntity
import com.stockcontrol.domain.model.StockItem
import javax.inject.Inject

class StockItemMapper @Inject constructor(
    private val salesMapper: SalesMapper,
    private val stockMapper: StockQuantitiesMapper
) : EntityMapper<StockITemEntity, StockItem> {

    override fun mapToEntity(domain: StockItem): StockITemEntity {
        return StockITemEntity(domain.id, domain.name, domain.price, domain.stock.map {
            stockMapper.mapToEntity(it)
        }, domain.sales.map {
            salesMapper.mapToEntity(it)
        }
        )
    }

    override fun mapFromEntity(entity: StockITemEntity): StockItem {
        return StockItem(entity.id, entity.name, entity.price, entity.stock.map {
            stockMapper.mapFromEntity(it)
        }, entity.sales.map {
            salesMapper.mapFromEntity(it)
        }
        )
    }

}