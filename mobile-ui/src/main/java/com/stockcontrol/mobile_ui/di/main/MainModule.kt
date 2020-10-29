package com.stockcontrol.mobile_ui.di.main

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stockcontrol.mobile_ui.ui.main.MainActivity
import com.stockcontrol.mobile_ui.ui.main.SalesAdapter
import com.stockcontrol.mobile_ui.ui.main.StockQuantitiesAdapter
//import com.stockcontrol.mobile_ui.ui.main.SalesAdapter
//import com.stockcontrol.mobile_ui.ui.main.StockQuantitiesAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
 class MainModule {

    @Provides
    fun bindSalesAdapter() : SalesAdapter {
        return SalesAdapter()
    }

    @Provides
    fun bindStockQuantitiesAdapter() : StockQuantitiesAdapter {
        return StockQuantitiesAdapter()
    }

    @Provides
    fun provideLinearLayoutManager(mainActivity: MainActivity) : LinearLayoutManager {
        return LinearLayoutManager(mainActivity, RecyclerView.VERTICAL , false)
    }

    @Provides
    fun provideAlertDialog(mainActivity: MainActivity) : AlertDialog.Builder{
        return AlertDialog.Builder(mainActivity)
    }
}