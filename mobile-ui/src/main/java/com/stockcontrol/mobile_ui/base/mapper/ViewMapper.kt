package com.stockcontrol.mobile_ui.base.mapper

interface ViewMapper <V , D>  {

    fun mapToView(domain : D) : V
}