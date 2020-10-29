package com.stockcontrol.mobile_ui.ui.main

import com.stockcontrol.mobile_ui.base.Event


class Resource <T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success (data: T?): Event<Resource<T>> {
            return Event(Resource(Status.SUCCESS, data, null))
        }

        fun <T> error(msg: String, data: T?): Event<Resource<T>> {
            return Event(Resource(Status.ERROR, data, msg))
        }

        fun <T> loading(data: T?): Event<Resource<T>> {
            return Event(Resource(Status.LOADING, data, null))
        }

    }
}