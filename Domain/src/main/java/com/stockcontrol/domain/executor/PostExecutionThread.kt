package com.stockcontrol.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler : Scheduler
}