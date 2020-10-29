package com.stockcontrol.mobile_ui.di.main

import androidx.lifecycle.ViewModel
import com.stockcontrol.mobile_ui.di.ViewModelKey
import com.stockcontrol.mobile_ui.ui.main.StockItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StockItemViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StockItemViewModel::class)
    abstract  fun bindStockItemViewModel(viewModel: StockItemViewModel) : ViewModel

}