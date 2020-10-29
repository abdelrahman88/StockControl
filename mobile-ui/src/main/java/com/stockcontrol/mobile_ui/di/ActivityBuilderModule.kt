package com.stockcontrol.mobile_ui.di

import com.stockcontrol.mobile_ui.di.main.MainModule
import com.stockcontrol.mobile_ui.di.main.StockItemViewModelModule
import com.stockcontrol.mobile_ui.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [MainModule::class , StockItemViewModelModule::class]
    )
    abstract fun contributeMainActivity() : MainActivity
}