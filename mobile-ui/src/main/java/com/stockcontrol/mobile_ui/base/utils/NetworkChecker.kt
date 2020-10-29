package com.stockcontrol.mobile_ui.base.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkChecker {
     fun checkInternet(context: Context) : Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }
}