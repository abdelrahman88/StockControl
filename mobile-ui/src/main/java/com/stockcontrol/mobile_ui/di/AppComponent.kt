package com.stockcontrol.mobile_ui.di

import android.app.Application
import com.stockcontrol.mobile_ui.base.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class
    , AppModule::class ,ActivityBuilderModule::class ,ViewModelFactoryModule::class ,
    DataModule::class , RemoteModule::class , UiModule::class] )
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build() : AppComponent
    }
}