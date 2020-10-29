package com.stockcontrol.mobile_ui.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stockcontrol.domain.interactors.browse.GetStockItem
import com.stockcontrol.domain.model.StockItem
import com.stockcontrol.mobile_ui.base.Event
import com.stockcontrol.mobile_ui.base.mapper.StockItemViewMapper
import com.stockcontrol.mobile_ui.base.model.StockItemView
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class StockItemViewModel @Inject constructor(
    private val getStockItem: GetStockItem ,
    private val mapper : StockItemViewMapper
) : ViewModel() {

    private val liveData = MutableLiveData<Event<Resource<StockItemView>>>()

    override fun onCleared() {
        getStockItem.dispose()
        super.onCleared()
    }

    fun getStockItem() : MutableLiveData<Event<Resource<StockItemView>>>{
        return liveData
    }

    fun fetchStockItemData(id : String){

        liveData.postValue(Resource.loading(null))
        getStockItem.execute(StockItemSubscriber(), GetStockItem.Params.forStockItem(id))
    }

    inner class StockItemSubscriber : DisposableSingleObserver<StockItem>(){

        override fun onError(e: Throwable) {
            liveData.postValue(Resource.error(e.localizedMessage,null))
        }

        override fun onSuccess(t: StockItem) {
            liveData.postValue(Resource.success(
                mapper.mapToView(t)
            ))
        }
    }
}