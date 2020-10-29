package com.stockcontrol.mobile_ui.base

import com.stockcontrol.mobile_ui.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
       return DaggerAppComponent.builder().application(this).build()
    }
}