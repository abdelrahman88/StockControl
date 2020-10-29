package com.stockcontrol.domain.interactors.browse

import com.stockcontrol.domain.executor.PostExecutionThread
import com.stockcontrol.domain.interactors.SingleUseCase
import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.domain.repository.StockItemRepository
import io.reactivex.Single
import javax.inject.Inject

open class GetStockItem @Inject constructor(private val stockItemRepository: StockItemRepository
                                       ,  postExecutionThread: PostExecutionThread )
    : SingleUseCase<StockItem , GetStockItem.Params>(postExecutionThread) {


    data class Params constructor(val id : String){
        companion object{
            fun forStockItem(id : String) : Params{
                return Params(id)
            }
        }

    }

    override fun buildSingleUseCase(params: Params?): Single<StockItem> {
        if(params == null) throw IllegalArgumentException("params can't be null")
        return stockItemRepository.getStockItemDetails(params.id)
    }
}