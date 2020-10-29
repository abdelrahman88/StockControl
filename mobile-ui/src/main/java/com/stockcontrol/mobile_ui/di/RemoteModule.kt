package com.stockcontrol.mobile_ui.di

import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.stockcontrol.data.repository.StockItemRemote
import com.stockcontrol.mobile_ui.BuildConfig
import com.stockcontrol.mobile_ui.base.utils.getDate
import com.stockcontrol.mobile_ui.base.utils.getOffsetDate
import com.stockcontrol.remote.StockItemRemoteImpl
import com.stockcontrol.remote.service.StockControlService
import com.stockcontrol.remote.service.StockControlServiceFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import java.util.*

@Module
abstract class RemoteModule {


    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideStockControlService(moshi: Moshi) : StockControlService{
            return StockControlServiceFactory.makeStockControlService(BuildConfig.DEBUG,moshi)
        }

        @Provides
        @JvmStatic
        fun provideMoshi(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Binds
    abstract fun bindStockItemRemote(stockItemRemoteImpl: StockItemRemoteImpl) : StockItemRemote
}


class DateAdapter {
    @FromJson
    fun fromJson(json: String): Date? = json.getDate()

    @ToJson
    fun toJson(date: Date) = date.getOffsetDate()
}