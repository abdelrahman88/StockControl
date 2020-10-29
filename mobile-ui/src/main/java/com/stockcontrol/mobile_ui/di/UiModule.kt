package com.stockcontrol.mobile_ui.di

import com.stockcontrol.domain.executor.PostExecutionThread
import com.stockcontrol.mobile_ui.base.UiThread
import dagger.Binds
import dagger.Module

@Module
abstract class UiModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread) : PostExecutionThread
}