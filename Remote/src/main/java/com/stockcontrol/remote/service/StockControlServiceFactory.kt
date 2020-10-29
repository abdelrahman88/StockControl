package com.stockcontrol.remote.service

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object StockControlServiceFactory {

    fun makeStockControlService(isDebug: Boolean ,  moshi : Moshi): StockControlService{
       return makeStockControlService(makeOkHttpClient(makeLoggingInterceptor(isDebug)) , moshi)
    }

    private fun makeStockControlService(okHttpClient: OkHttpClient , moshi : Moshi): StockControlService {
       val retrofit =  Retrofit.Builder()
            .baseUrl("http://mobcoamir-001-site14.ctempurl.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(StockControlService::class.java)
    }


    private fun makeOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(120 , TimeUnit.SECONDS)
            .readTimeout(120 , TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(isDebug : Boolean) : HttpLoggingInterceptor{
        val logging = HttpLoggingInterceptor()
        logging.level =  if(isDebug){
            HttpLoggingInterceptor.Level.BODY
        }
        else{
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }
}