package com.stockcontrol.domain.interactors

import com.stockcontrol.domain.executor.PostExecutionThread
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase <T, in Params > constructor(private val postExecutionThread: PostExecutionThread) {

    private val disposables  = CompositeDisposable()
    abstract fun buildSingleUseCase(params: Params? = null ) : Single<T>

    open fun execute(observer : DisposableSingleObserver<T> , params: Params? = null){
        val single = this.buildSingleUseCase(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)

        addDisposables(single.subscribeWith(observer))
    }

    fun dispose(){
        disposables.dispose()
    }
    private fun addDisposables(disposable: Disposable){
        disposables.add(disposable)
    }
}